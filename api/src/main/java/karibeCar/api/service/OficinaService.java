package karibeCar.api.service;

import karibeCar.api.entity.Oficina;
import karibeCar.api.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaService {

    @Autowired
    private OficinaRepository oficinaRepository;

    public List<Oficina> getAll() {
        return oficinaRepository.findAll();
    }

    public Optional<Oficina> getById(int id) {
        return oficinaRepository.findById(id);
    }

    public Oficina save(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    public Oficina update(int id, Oficina oficina) {
        return oficinaRepository.findById(id).map(existing -> {
            existing.setProvincia(oficina.getProvincia());
            existing.setCanton(oficina.getCanton());
            existing.setDireccion(oficina.getDireccion());
            existing.setTelefono(oficina.getTelefono());
            existing.setHorario(oficina.getHorario());
            existing.setDescripcion(oficina.getDescripcion());
            existing.setGoogle_maps(oficina.getGoogle_maps());
            return oficinaRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Oficina no encontrada con ID: " + id));
    }

    public void delete(int id) {
        oficinaRepository.deleteById(id);
    }
}
