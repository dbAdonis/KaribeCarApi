package karibeCar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import karibeCar.api.entity.Vehiculo;
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{
    
}
