package egs.assignment.kourosh.service;

import egs.assignment.kourosh.entity.Product;
import egs.assignment.kourosh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findByProductName(String productName){
        return productRepository.findByName(productName);
    }

    public Stream<Product> findByTitle(String title){
        return  productRepository.findByTitle(title);
    }

    public Future<List<Product>> findByTitleAsync(String title){
        return productRepository.findByTitleAsync(title);
    }
}
