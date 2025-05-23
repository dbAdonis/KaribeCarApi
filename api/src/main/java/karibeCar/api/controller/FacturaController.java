package karibeCar.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karibeCar.api.entity.Factura;
import karibeCar.api.service.EmailService;
import karibeCar.api.service.FacturaService;

@CrossOrigin(origins = "*") 
@Tag(name = "Facturas", description = "API para gestionar facturas")
@RestController
@RequestMapping("/facturas")
public class FacturaController {
    
    @Autowired
    private FacturaService facturaService;

    @Autowired
    private EmailService emailService;

    @GetMapping
    @Operation(summary = "Obtener todas las facturas", description = "Devuelve una lista de facturas")
    public List<Factura> get() {
        return facturaService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una factura por ID", description = "Busca una factura en la base de datos según su ID")
    public Optional<Factura> getById(@PathVariable int id) {
        
        return facturaService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar una nueva factura", description = "Agrega una nueva factura a la base de datos")
    public Factura add(@RequestBody Factura factura) {
        Factura guardada = facturaService.save(factura);

        if (guardada != null && guardada.getIdCliente() != null) {
            String correo = guardada.getIdCliente().getCorreo();
            String nombre = guardada.getIdCliente().getNombre();
            String apellido = guardada.getIdCliente().getApellido();

            String asunto = "Factura de alquiler generada";
            String cuerpo = "Hola " + nombre + " " + apellido + ",\n\nTu factura ha sido generada exitosamente.\n\n"
                    + guardada.getDetalle() + "\n\n"
                    + "Gracias por usar nuestro servicio.";

            emailService.enviarCorreo(correo, asunto, cuerpo);
        }

        return guardada;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar una factura", description = "Modifica una factura existente en la base de datos")
    public Factura update(@PathVariable int id, @RequestBody Factura factura) {
        return facturaService.update(id, factura);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una factura", description = "Elimina una factura de la base de datos")
    public void delete(@PathVariable int id) {
        facturaService.delete(id);
    }

}
