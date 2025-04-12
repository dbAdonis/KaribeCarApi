package karibeCar.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipos_vehiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoVehiculo;

    @Column(nullable = false)
    private String nombre; // Ejemplo: "Sedán", "SUV", etc.

    @Column(nullable = false)
    private String descripcion;
}
