package soda.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import soda.api.entity.Product;  // Usa la entidad correcta
import soda.api.repository.ProductRepository;  // Usa el repositorio correcto

@Service
@AllArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public List<Product> get() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(int id) {
        return productRepository.findById(id);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }

    public Product update(int id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setCategory(product.getCategory());
            return productRepository.save(updatedProduct);
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
    }
}
