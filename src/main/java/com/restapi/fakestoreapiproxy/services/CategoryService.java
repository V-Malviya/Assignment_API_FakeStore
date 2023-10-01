package com.restapi.fakestoreapiproxy.services;

import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<List<Category>> getAllCategories();

    Optional<List<Product>> getAllProductsInCategory(String category);
}
