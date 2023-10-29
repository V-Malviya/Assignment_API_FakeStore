package com.restapi.fakestoreapiproxy.repositories;

import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category save(Category category);
    List<Category> findAll();
    Category findCategoryByName(String CategoryName);
    @Query(value = "SELECT * FROM product p WHERE p.category_id IN (SELECT id FROM category WHERE name=:categoryName)",nativeQuery = true)
    List<Product> productsInCategoryByName(String categoryName);
}
