package karibeCar.api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "idAlquiler", nullable = false)
    private Alquiler idAlquiler;

    @Column(nullable = false, length = 500)
    private String detalle;

    @Column(nullable = false)
    private double montoTotal;

    @Column(nullable = false)
    private String metodoPago;

    @Column(nullable = false)
    private LocalDateTime fecha;
    
}
