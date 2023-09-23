package com.restapi.fakestoreapiproxy.services;
public interface CategoryService {
    String getAllCategories();

    String getAllProductsInCategory(String category);
}
