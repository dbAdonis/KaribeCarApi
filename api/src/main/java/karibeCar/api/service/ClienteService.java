package karibeCar.api.service;

import karibeCar.api.entity.Cliente;
import karibeCar.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getById(int id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(int id, Cliente cliente) {
        return clienteRepository.findById(id).map(existing -> {
            existing.setNombre(cliente.getNombre());
            existing.setApellido(cliente.getApellido());
            existing.setDireccion(cliente.getDireccion());
            existing.setCelular(cliente.getCelular());
            existing.setCorreo(cliente.getCorreo());
            return clienteRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    public void delete(int id) {
        clienteRepository.deleteById(id);
    }
}
