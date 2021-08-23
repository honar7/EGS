package egs.assignment.kourosh.controller;
import java.util.List;
import egs.assignment.kourosh.entity.Product;
import egs.assignment.kourosh.exception.ProductNotFoundException;
import egs.assignment.kourosh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController() {
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) throws ProductNotFoundException {
        return productService.getProduct(id);
    }

    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAutority('ROLE_ADMIN')")
    @PostMapping("/products/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAutority('ROLE_ADMIN')")
    @PutMapping("/products/edit/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable long id){
        return productService.updateProduct(product,id);
    }

    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAutority('ROLE_ADMIN')")
    @DeleteMapping("/products/{id}")
    public void removeProduct(@PathVariable long id){
        productService.removeProduct(id);
    }

}
