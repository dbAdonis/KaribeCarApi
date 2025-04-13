package karibeCar.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karibeCar.api.entity.Oficina;
import karibeCar.api.service.OficinaService;

@CrossOrigin(origins = "*") // Permitir acceso desde cualquier origen
@Tag(name = "Oficinas", description = "API para gestionar oficinas") // Grupo en Swagger
@RestController
@RequestMapping("/oficinas")
public class OficinaController {

    @Autowired
    private OficinaService oficinaService;

    @GetMapping
    @Operation(summary = "Obtener todas las oficinas", description = "Devuelve una lista de oficinas")
    public List<Oficina> get() {
        return oficinaService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una oficina por ID", description = "Busca una oficina en la base de datos según su ID")
    public Optional<Oficina> getById(@PathVariable int id) {
        return oficinaService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar una nueva oficina", description = "Agrega una nueva oficina a la base de datos")
    public Oficina add(@RequestBody Oficina oficina) {
        return oficinaService.save(oficina);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar una oficina", description = "Modifica una oficina existente en la base de datos")
    public Oficina update(@PathVariable int id, @RequestBody Oficina oficina) {
        return oficinaService.update(id, oficina);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una oficina", description = "Elimina una oficina de la base de datos")
    public void delete(@PathVariable int id) {
        oficinaService.delete(id);
    }
}
