package karibeCar.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "oficinas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOficina;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String canton;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false, unique = true)
    private String telefono;

}
