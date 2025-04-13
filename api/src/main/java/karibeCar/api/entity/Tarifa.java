package karibeCar.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tarifas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarifa;

    @Column(nullable = false)
    private double precio;

    @ManyToOne
    @JoinColumn(name = "idTipoVehiculo", nullable = false)
    private TipoVehiculo idTipoVehiculo;
}
