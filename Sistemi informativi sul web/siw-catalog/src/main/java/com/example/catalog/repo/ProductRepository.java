package com.example.catalog.repo;

import com.example.catalog.model.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAllByOrderByNameAsc();

  List<Product> findByTypeIgnoreCaseOrderByNameAsc(String type);

  List<Product> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

  @Query("select distinct p from Product p left join fetch p.similarProducts where p.id = :id")
  Optional<Product> findByIdWithSimilar(@Param("id") Long id);
}
