package karibeCar.api.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import karibeCar.api.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    boolean existsByIdAlquiler_IdVehiculo_IdVehiculoAndIdAlquiler_FechaInicioLessThanAndIdAlquiler_FechaFinGreaterThan(
    int idVehiculo, LocalDateTime fechaFin, LocalDateTime fechaInicio
);
}
