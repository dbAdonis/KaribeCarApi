package karibeCar.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karibeCar.api.entity.Cliente;
import karibeCar.api.service.ClienteService;

@CrossOrigin(origins = "*") // Permitir acceso desde cualquier origen
@Tag(name = "Clientes", description = "API para gestionar clientes") // Grupo en Swagger
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Obtener todos los clientes", description = "Devuelve una lista de clientes")
    public List<Cliente> get() {
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un cliente por ID", description = "Busca un cliente en la base de datos según su ID")
    public Optional<Cliente> getById(@PathVariable int id) {
        return clienteService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo cliente", description = "Agrega un nuevo cliente a la base de datos")
    public Cliente add(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un cliente", description = "Modifica un cliente existente en la base de datos")
    public Cliente update(@PathVariable int id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un cliente", description = "Elimina un cliente de la base de datos")
    public void delete(@PathVariable int id) {
        clienteService.delete(id);
    }
}
