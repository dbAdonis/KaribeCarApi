package karibeCar.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karibeCar.api.entity.Vehiculo;
import karibeCar.api.service.VehiculoService;

@CrossOrigin(origins = "*") // Permitir acceso desde cualquier origen
@Tag(name = "Vehículos", description = "API para gestionar vehículos") // Grupo en Swagger
@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    @Operation(summary = "Obtener todos los vehículos", description = "Devuelve una lista de vehículos")
    public List<Vehiculo> get() {
        return vehiculoService.get();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un vehículo por ID", description = "Busca un vehículo en la base de datos según su ID")
    public Optional<Vehiculo> getById(@PathVariable int id) {
        return vehiculoService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo vehículo", description = "Agrega un nuevo vehículo a la base de datos")
    public Vehiculo add(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.add(vehiculo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un vehículo", description = "Modifica un vehículo existente en la base de datos")
    public Vehiculo update(@PathVariable int id, @RequestBody Vehiculo vehiculo) {
        return vehiculoService.update(id, vehiculo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un vehículo", description = "Elimina un vehículo de la base de datos")
    public void delete(@PathVariable int id) {
        vehiculoService.delete(id);
    }

    @GetMapping("/tipo/{idTipoVehiculo}")
    public List<Vehiculo> getVehiculosPorTipo(@PathVariable int idTipoVehiculo) {
        return vehiculoService.obtenerVehiculosPorTipo(idTipoVehiculo);
    }

}
