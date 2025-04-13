package karibeCar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import karibeCar.api.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer>{
}
