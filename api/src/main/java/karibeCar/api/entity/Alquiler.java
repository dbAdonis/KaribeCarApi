package karibeCar.api.entity;

import java.time.LocalDate;

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
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false)
    private int CantidadDias;
}
