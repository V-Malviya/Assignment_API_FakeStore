package com.restapi.fakestoreapiproxy.controllers;

import com.restapi.fakestoreapiproxy.dtos.ProductDto;
import com.restapi.fakestoreapiproxy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    ProductController(ProductService productService)
    {
        this.productService=productService;
    }
    @GetMapping()
    public String getAllProducts()
    {
        return "Returning all products";
    }
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") long productId)
    {
        return "Returning product wit id :"+productId;
    }
    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto)
    {
        return "Adding new Product with id :"+productDto.toString();
    }
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") long productId, @RequestBody ProductDto newDetails)
    {
        return "Updating product wit id"+productId+newDetails;
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") long productId)
    {
        return "Deleting product wit id :"+productId;
    }
}
