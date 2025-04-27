package karibeCar.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import karibeCar.api.entity.Vehiculo;
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{
    
    List<Vehiculo> findByIdTipoVehiculoIdTipoVehiculo(int idTipoVehiculo);

    
}
