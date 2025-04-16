package karibeCar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import karibeCar.api.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
}
