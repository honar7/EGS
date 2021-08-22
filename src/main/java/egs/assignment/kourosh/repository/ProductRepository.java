package egs.assignment.kourosh.repository;

import egs.assignment.kourosh.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    Stream<Product> findByTitle(String title);
    @Async
    Future<List<Product>> findByTitleAsync(String title);
}
