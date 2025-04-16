package karibeCar.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import karibeCar.api.entity.Reserva;
import karibeCar.api.repository.ReservaRepository;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAll(){
        return reservaRepository.findAll();
    }

    public Optional<Reserva> getById(int id){
        return reservaRepository.findById(id);
    }

    public Reserva save(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public Reserva update(int id, Reserva reserva){
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        if (reservaOpt.isPresent()) {
            Reserva reservaActualizada = reservaOpt.get();

            reservaActualizada.setIdOficina(reserva.getIdOficina());
            reservaActualizada.setIdCliente(reserva.getIdCliente());
            reservaActualizada.setIdAlquiler(reserva.getIdAlquiler());
            reservaActualizada.setEstado(reserva.getEstado());
            reservaActualizada.setFecha(reserva.getFecha());
            
            return reservaRepository.save(reservaActualizada);
        }else{
            throw new RuntimeException("Reserva no encontrada con el ID: " + id);
        }
    }

    public void delete(int id){
        reservaRepository.deleteById(id);
    }
}
