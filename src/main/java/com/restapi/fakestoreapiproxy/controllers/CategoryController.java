package com.restapi.fakestoreapiproxy.controllers;

import com.restapi.fakestoreapiproxy.dtos.ProductResponseDto;
import com.restapi.fakestoreapiproxy.exceptions.NoProductFoundException;
import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<String>> getAllCategories() throws NoProductFoundException
    {
        Optional<List<Category>> optionalList=categoryService.getAllCategories();
        if (optionalList.isEmpty()) {
            throw new NoProductFoundException("There are no categories added in database ");
        }
        List<String> categorylist=new ArrayList<>();
        for(Category p:optionalList.get())
        {
            categorylist.add(p.getName());
        }
        ResponseEntity<List<String>>response =new ResponseEntity<>(categorylist, HttpStatus.OK);
        return response;
    }
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<ProductResponseDto>> getAllProductsInCategory(@PathVariable("categoryName") String category)
            throws NoProductFoundException
    {
        Optional<List<Product>> optionalList=categoryService.getAllProductsInCategory(category);
        if (optionalList.isEmpty()) {
            throw new NoProductFoundException("There are no product availbale in this "+category+" categories.");
        }
        List<ProductResponseDto> productlist=new ArrayList<>();
        for(Product p:optionalList.get())
        {
            productlist.add(productToResponseDto(p));
        }
        ResponseEntity<List<ProductResponseDto>> response=new ResponseEntity<>(productlist,HttpStatus.OK);
        return response;
    }
    private ProductResponseDto productToResponseDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setId(product.getId());
        responseDto.setCategory(product.getCategory().getName());
        responseDto.setImage(product.getImageUrl());
        return responseDto;
    }
}
