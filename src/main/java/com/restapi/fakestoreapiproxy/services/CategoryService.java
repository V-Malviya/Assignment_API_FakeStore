package com.restapi.fakestoreapiproxy.services;

import com.restapi.fakestoreapiproxy.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    String getAllProductsInCategory(String category);
}
