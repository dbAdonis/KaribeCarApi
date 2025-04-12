package karibeCar.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import karibeCar.api.entity.TipoVehiculo;
import karibeCar.api.repository.TipoVehiculoRepository;

@Service
public class TipoVehiculoService {

    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    public TipoVehiculo add(TipoVehiculo tipoVehiculo) {
        return tipoVehiculoRepository.save(tipoVehiculo);
    }

    public List<TipoVehiculo> get() {
        return tipoVehiculoRepository.findAll();
    }

    public Optional<TipoVehiculo> getById(int id) {
        return tipoVehiculoRepository.findById(id);
    }

    public void delete(int id) {
        tipoVehiculoRepository.deleteById(id);
    }

    public TipoVehiculo update(int id, TipoVehiculo tipoVehiculo) {
        Optional<TipoVehiculo> existente = tipoVehiculoRepository.findById(id);
        if (existente.isPresent()) {
            TipoVehiculo actualizado = existente.get();
            actualizado.setNombre(tipoVehiculo.getNombre());
            actualizado.setDescripcion(tipoVehiculo.getDescripcion());
            return tipoVehiculoRepository.save(actualizado);
        } else {
            throw new RuntimeException("Tipo de vehículo no encontrado con ID: " + id);
        }
    }
}
