package karibeCar.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import karibeCar.api.entity.Alquiler;
import karibeCar.api.entity.Cliente;
import karibeCar.api.entity.Factura;
import karibeCar.api.entity.Reserva;
import karibeCar.api.entity.Tarifa;
import karibeCar.api.entity.Vehiculo;
import karibeCar.api.repository.FacturaRepository;
import karibeCar.api.repository.ReservaRepository;
import karibeCar.api.repository.TarifaRepository;
import karibeCar.api.repository.VehiculoRepository;

@Service
public class ReservaCompletaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private TarifaRepository tarifaRepository;

    @Autowired
    private EmailService emailService;

    @Transactional
    public Reserva crearReservaYFactura(Reserva reserva) {
        // 1. Guardar la reserva
        Reserva reservaGuardada = reservaRepository.save(reserva);

        // 2. Obtener datos necesarios
        Cliente cliente = reservaGuardada.getIdCliente();
        Alquiler alquiler = reservaGuardada.getIdAlquiler();

        Tarifa tarifaCompleta = tarifaRepository.findById(alquiler.getIdTarifa().getIdTarifa())
        .orElseThrow(() -> new RuntimeException("Tarifa no encontrada"));

        int dias = alquiler.getCantidadDias();
        double precioPorDia = tarifaCompleta.getPrecio();
        double montoTotal = dias * precioPorDia;

        Vehiculo vehiculoCompleto = vehiculoRepository.findById(alquiler.getIdVehiculo().getIdVehiculo())
        .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        // 3. Crear la factura
        Factura factura = new Factura();
        LocalDateTime fechaHora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fechaHora.format(formatter);

        factura.setIdCliente(cliente);
        factura.setIdAlquiler(alquiler);
        factura.setMontoTotal(montoTotal);
        factura.setMetodoPago("Efectivo");
        factura.setFecha(fechaHora);
        factura.setDetalle(
    "Factura emitida el " + fechaFormateada + ".\n\n" +
    "Detalle del servicio:\n" +
    "- Vehículo alquilado: " + vehiculoCompleto.getMarca() + " " + vehiculoCompleto.getModelo() + " (" + vehiculoCompleto.getAño() + ")\n" +
    "- Número de placa: " + vehiculoCompleto.getPlaca() + "\n" +
    "- Período de alquiler: del " + reservaGuardada.getIdAlquiler().getFechaInicio() +
    " al " + reservaGuardada.getIdAlquiler().getFechaFin() + "\n" +
    "- Duración total: " + dias + " días\n" +
    "- Tarifa diaria: " + precioPorDia + " colones\n" +
    "- Monto total a pagar: " + montoTotal + " colones\n\n" +
    "Agradecemos su confianza en nuestros servicios. Para cualquier consulta, no dude en contactarnos."
);

        // 4. Guardar factura
        facturaRepository.save(factura);

        if (cliente.getCorreo() != null && !cliente.getCorreo().isBlank()) {
            String asunto = "Factura de alquiler generada";
            String cuerpo = "Hola " + cliente.getNombre() + " " + cliente.getApellido() + ",\n\n"
                    + "Tu factura ha sido generada exitosamente.\n\n"
                    + factura.getDetalle() + "\n\n"
                    + "Gracias por usar nuestro servicio.";
            emailService.enviarCorreo(cliente.getCorreo(), asunto, cuerpo);
        }

        return reservaGuardada; // Devuelve reserva (con IDs generados)
    }
}
