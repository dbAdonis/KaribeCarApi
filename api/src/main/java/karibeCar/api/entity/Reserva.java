package karibeCar.api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "idOficina", nullable = false)
    private Oficina idOficina;

    @ManyToOne
    @JoinColumn(name = "idAlquiler", nullable = false)
    private Alquiler idAlquiler;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private LocalDateTime fecha;

}
