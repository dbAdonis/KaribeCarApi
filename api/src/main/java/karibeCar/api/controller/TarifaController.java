package karibeCar.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karibeCar.api.entity.Tarifa;
import karibeCar.api.service.TarifaService;

@CrossOrigin(origins = "*") // Permitir acceso desde cualquier origen
@Tag(name = "Tarifas", description = "API para gestionar tarifas") // Grupo en Swagger
@RestController
@RequestMapping("/tarifas")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;

    @GetMapping
    @Operation(summary = "Obtener todas las tarifas", description = "Devuelve una lista de tarifas")
    public List<Tarifa> get() {
        return tarifaService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una tarifa por ID", description = "Busca una tarifa en la base de datos según su ID")
    public Optional<Tarifa> getById(@PathVariable int id) {
        return tarifaService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar una nueva tarifa", description = "Agrega una nueva tarifa a la base de datos")
    public Tarifa add(@RequestBody Tarifa tarifa) {
        return tarifaService.save(tarifa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar una tarifa", description = "Modifica una tarifa existente en la base de datos")
    public Tarifa update(@PathVariable int id, @RequestBody Tarifa tarifa) {
        return tarifaService.update(id, tarifa);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una tarifa", description = "Elimina una tarifa de la base de datos")
    public void delete(@PathVariable int id) {
        tarifaService.delete(id);
    }
}
