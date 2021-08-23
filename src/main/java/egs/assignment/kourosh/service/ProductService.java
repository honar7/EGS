package egs.assignment.kourosh.service;

import egs.assignment.kourosh.entity.Product;
import egs.assignment.kourosh.exception.ProductNotFoundException;
import egs.assignment.kourosh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.net.URI;
import java.text.MessageFormat;



@Service
public class ProductService  {

    @Autowired
    private ProductRepository productRepository;

    public ProductService() {
    }

    public Optional<Product> findByProductName(String productName){
        return productRepository.findByName(productName);
    }

    public Product getProduct(long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent())
            throw new ProductNotFoundException(MessageFormat.format("Product Id = {0} Is Not Found :( ", id));
        return productOptional.get();
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<Product> createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProduct.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    public ResponseEntity<Product> updateProduct(Product product, long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent())
            return ResponseEntity.notFound().build();
        product.setId(id);
        productRepository.save(product);
        return ResponseEntity.noContent().build();
    }

    public void removeProduct(long id) {
        productRepository.deleteById(id);
    }

}
