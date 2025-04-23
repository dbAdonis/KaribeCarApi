package karibeCar.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehiculo;

    @ManyToOne
    @JoinColumn(name = "idTipoVehiculo", nullable = false)
    private TipoVehiculo idTipoVehiculo;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String año;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String combustible;

    @Column(nullable = false)
    private String pasajeros;

    @Column(nullable = false)
    private String aireAcondicionado;

    @Column(nullable = false)
    private String transmision;

    @Column(nullable = false)
    private String cilindraje;

    @Column(nullable = false)
    private String potencia;

    @Column(nullable = false)
    private int kilometraje;

    @Column(nullable = false)
    private String traccion;
}
