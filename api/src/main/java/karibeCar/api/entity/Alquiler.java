package karibeCar.api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alquileres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Alquiler {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlquiler;

    @ManyToOne
    @JoinColumn(name = "idVehiculo", nullable = false)
    private Vehiculo idVehiculo;

    @ManyToOne
    @JoinColumn(name = "idTarifa", nullable = false)
    private Tarifa idTarifa;

    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @Column(nullable = false)
    private LocalDateTime fechaFin;

    @Column(nullable = false)
    private int CantidadDias;
}
