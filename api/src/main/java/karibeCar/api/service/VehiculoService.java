package karibeCar.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import karibeCar.api.entity.Vehiculo;
import karibeCar.api.repository.VehiculoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public Vehiculo add(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public List<Vehiculo> get() {
        return vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> getById(int id) {
        return vehiculoRepository.findById(id);
    }

    public void delete(int id) {
        vehiculoRepository.deleteById(id);
    }

    public Vehiculo update(int id, Vehiculo vehiculo) {
        Optional<Vehiculo> existingVehiculo = vehiculoRepository.findById(id);
        if (existingVehiculo.isPresent()) {
            Vehiculo updatedVehiculo = existingVehiculo.get();
            
            updatedVehiculo.setIdTipoVehiculo(vehiculo.getIdTipoVehiculo());
            updatedVehiculo.setMarca(vehiculo.getMarca());
            updatedVehiculo.setMarca(vehiculo.getMarca());
            updatedVehiculo.setModelo(vehiculo.getModelo());
            updatedVehiculo.setAño(vehiculo.getAño());
            updatedVehiculo.setPlaca(vehiculo.getPlaca());
            updatedVehiculo.setCombustible(vehiculo.getCombustible());
            updatedVehiculo.setPasajeros(vehiculo.getPasajeros());
            updatedVehiculo.setAireAcondicionado(vehiculo.getAireAcondicionado());
            updatedVehiculo.setTransmision(vehiculo.getTransmision());
            updatedVehiculo.setCilindraje(vehiculo.getCilindraje());
            updatedVehiculo.setPotencia(vehiculo.getPotencia());
            updatedVehiculo.setKilometraje(vehiculo.getKilometraje());
            updatedVehiculo.setTraccion(vehiculo.getTraccion());

            return vehiculoRepository.save(updatedVehiculo);
        } else {
            throw new RuntimeException("Vehículo no encontrado con ID: " + id);
        }
    }
}
