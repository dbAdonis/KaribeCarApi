package karibeCar.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karibeCar.api.entity.Reserva;
import karibeCar.api.service.ReservaService;

@CrossOrigin(origins = "*") 
@Tag(name = "Reservas", description = "API para gestionar reservas")
@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    @Operation(summary = "Obtener todas las reservas", description = "Devuelve una lista de reservas")
    public List<Reserva> get() {
        return reservaService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una reserva por ID", description = "Busca una reserva en la base de datos según su ID")
    public Optional<Reserva> getById(@PathVariable int id) {
        return reservaService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar una nueva reserva", description = "Agrega una nueva reserva a la base de datos")
    public Reserva add(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar una reserva", description = "Modifica una reserva existente en la base de datos")
    public Reserva update(@PathVariable int id, @RequestBody Reserva reserva) {
        return reservaService.update(id, reserva);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reserva", description = "Elimina una reserva de la base de datos")
    public void delete(@PathVariable int id) {
        reservaService.delete(id);
    }
}
