package com.restapi.fakestoreapiproxy.repositories;

import com.restapi.fakestoreapiproxy.models.Product;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
     Product save(Product product);
     Product findProductById(Long id);
     void deleteProductById(Long id);
     boolean existsById(Long id);
}
