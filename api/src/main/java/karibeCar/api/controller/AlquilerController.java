package karibeCar.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karibeCar.api.entity.Alquiler;
import karibeCar.api.service.AlquilerService;

@CrossOrigin(origins = "*") 
@Tag(name = "Alquileres", description = "API para gestionar alquileres")
@RestController
@RequestMapping("/alquileres")
public class AlquilerController {
    @Autowired
    private AlquilerService alquilerService;

    @GetMapping
    @Operation(summary = "Obtener todos los alquileres", description = "Devuelve una lista de alquileres")
    public List<Alquiler> get() {
        return alquilerService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un alquiler por ID", description = "Busca un alquiler en la base de datos según su ID")
    public Optional<Alquiler> getById(@PathVariable int id) {
        return alquilerService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo alquiler", description = "Agrega un nuevo alquiler a la base de datos")
    public Alquiler add(@RequestBody Alquiler alquiler) {
        return alquilerService.save(alquiler);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un alquiler", description = "Modifica un alquiler existente en la base de datos")
    public Alquiler update(@PathVariable int id, @RequestBody Alquiler alquiler) {
        return alquilerService.update(id, alquiler);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un alquiler", description = "Elimina un alquiler de la base de datos")
    public void delete(@PathVariable int id) {
        alquilerService.delete(id);
    }
}
