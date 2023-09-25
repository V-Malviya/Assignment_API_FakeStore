package com.restapi.fakestoreapiproxy.controllers;

import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    CategoryController(CategoryService categoryService)
    {
        this.categoryService=categoryService;
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories()
    {
        List list=categoryService.getAllCategories();
        ResponseEntity<List<Category>>response =new ResponseEntity<>(list, HttpStatus.OK);
        return response;
    }
    @GetMapping("/category/{categoryName}")
    public String getAllProductsInCategory(@PathVariable("categoryName") String category)
    {
        return "Return List of all products in category "+category;
    }
}
