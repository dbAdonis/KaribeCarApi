package karibeCar.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import karibeCar.api.entity.Alquiler;
import karibeCar.api.repository.AlquilerRepository;

@Service
public class AlquilerService {
    
    @Autowired
    private AlquilerRepository alquilerRepository;

    public List<Alquiler> getAll(){
        return alquilerRepository.findAll();
    }

    public Optional<Alquiler> getById(int id){
        return alquilerRepository.findById(id);
    }

    public Alquiler save(Alquiler alquiler){
        return alquilerRepository.save(alquiler);
    }

    public Alquiler update(int id, Alquiler alquiler){
        Optional<Alquiler> alquilerOpt = alquilerRepository.findById(id);
        if (alquilerOpt.isPresent()) {
            Alquiler alquilerActualizado = alquilerOpt.get();

            alquilerActualizado.setIdVehiculo(alquiler.getIdVehiculo());
            alquilerActualizado.setIdTarifa(alquiler.getIdTarifa());
            alquilerActualizado.setFechaInicio(alquiler.getFechaInicio());
            alquilerActualizado.setFechaFin(alquiler.getFechaFin());
            alquilerActualizado.setCantidadDias(alquiler.getCantidadDias());

            return alquilerRepository.save(alquilerActualizado);
        }else{
            throw new RuntimeException("Alquiler no encontrado con el ID: " + id); 
        }
    }

    public void delete(int id){
        alquilerRepository.deleteById(id);
    }
}
