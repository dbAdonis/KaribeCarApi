package karibeCar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import karibeCar.api.entity.Alquiler;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer>{
}
