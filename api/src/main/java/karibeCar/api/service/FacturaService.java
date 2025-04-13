package karibeCar.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import karibeCar.api.entity.Factura;
import karibeCar.api.repository.FacturaRepository;

@Service
public class FacturaService {
    
    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> getAll(){
        return facturaRepository.findAll();
    }

    public Optional<Factura> getById(int id){
        return facturaRepository.findById(id);
    }

    public Factura save(Factura factura){
        return facturaRepository.save(factura);
    }

    public Factura update(int id, Factura factura){
        Optional<Factura> facturaOpt = facturaRepository.findById(id);

        if (facturaOpt.isPresent()) {
            Factura facturaActualizada = facturaOpt.get();

            facturaActualizada.setIdCliente(factura.getIdCliente());
            facturaActualizada.setIdAlquiler(factura.getIdAlquiler());
            facturaActualizada.setDetalle(factura.getDetalle());
            facturaActualizada.setMontoTotal(factura.getMontoTotal());
            facturaActualizada.setMetodoPago(factura.getMetodoPago());
            facturaActualizada.setFecha(factura.getFecha());

            return facturaRepository.save(facturaActualizada);
        }else{
            throw new RuntimeException("Factura no encontrada con el ID: " + id);
        }

    }

    public void delete(int id){
        facturaRepository.deleteById(id);
    }
}
