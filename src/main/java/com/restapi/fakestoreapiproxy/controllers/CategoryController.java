package com.restapi.fakestoreapiproxy.controllers;

import com.restapi.fakestoreapiproxy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String getAllCategories()
    {
        return "Return all categories :";
    }
    @GetMapping("/category/{categoryName}")
    public String getAllProductsInCategory(@PathVariable("categoryName") String category)
    {
        return "Return List of all products in category "+category;
    }
}
