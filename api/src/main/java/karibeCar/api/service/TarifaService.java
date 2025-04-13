package karibeCar.api.service;

import karibeCar.api.entity.Tarifa;
import karibeCar.api.repository.TarifaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    public List<Tarifa> getAll() {
        return tarifaRepository.findAll();
    }

    public Optional<Tarifa> getById(int id) {
        return tarifaRepository.findById(id);
    }

    public Tarifa save(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    public Tarifa update(int id, Tarifa tarifa) {
        Optional<Tarifa> existingTarifa = tarifaRepository.findById(id);
        if (existingTarifa.isPresent()) {
            Tarifa updatedTarifa = existingTarifa.get();

            updatedTarifa.setPrecio(tarifa.getPrecio());
            updatedTarifa.setIdTipoVehiculo(tarifa.getIdTipoVehiculo());
            
            return tarifaRepository.save(updatedTarifa);
        } else {
            throw new RuntimeException("Tarifa no encontrado con ID: " + id);
        }   
    }

    public void delete(int id) {
        tarifaRepository.deleteById(id);
    }
}
