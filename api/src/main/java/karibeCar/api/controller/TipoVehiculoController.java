package karibeCar.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karibeCar.api.entity.TipoVehiculo;
import karibeCar.api.service.TipoVehiculoService;

@CrossOrigin(origins = "*")
@Tag(name = "Tipos de Vehículo", description = "API para gestionar tipos de vehículo")
@RestController
@RequestMapping("/tiposVehiculo")
public class TipoVehiculoController {

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @GetMapping
    @Operation(summary = "Obtener todos los tipos de vehículo")
    public List<TipoVehiculo> get() {
        return tipoVehiculoService.get();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un tipo de vehículo por ID")
    public Optional<TipoVehiculo> getById(@PathVariable int id) {
        return tipoVehiculoService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo tipo de vehículo")
    public TipoVehiculo add(@RequestBody TipoVehiculo tipoVehiculo) {
        return tipoVehiculoService.add(tipoVehiculo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un tipo de vehículo")
    public TipoVehiculo update(@PathVariable int id, @RequestBody TipoVehiculo tipoVehiculo) {
        return tipoVehiculoService.update(id, tipoVehiculo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un tipo de vehículo")
    public void delete(@PathVariable int id) {
        tipoVehiculoService.delete(id);
    }
}
