package com.restapi.fakestoreapiproxy.controllers;

import com.restapi.fakestoreapiproxy.dtos.ProductDto;
import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    public ResponseEntity<ProductDto[]> getAllProducts()
    {
        ProductDto[] productList=productService.getAllProducts();
//        for(ProductDto X:productList)
//        {
//
//        }
        ResponseEntity<ProductDto[]> response=new ResponseEntity<>(productList,HttpStatus.OK);
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId)
    {
        // ideally we should have a proper ProductResponseDto and ProductRequestDto but here we are returning
        // product in response body of response entity.
        Product product=productService.getProductById(productId);
        MultiValueMap<String,String> header=new LinkedMultiValueMap<>();
        header.add("auth-token","Nirlaj_tu_phir_agaya XD");
        System.out.println(product.toString());
//        ResponseEntity<Product> response=new ResponseEntity<>(product,header,HttpStatus.NOT_MODIFIED);
//        return response;
        ResponseEntity<Product> response=new ResponseEntity(product, header ,HttpStatus.OK);
        return response;
    }
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto)
    {
        Product product=productService.addNewProduct(productDto);
        ResponseEntity<Product> response=new ResponseEntity<>(product,HttpStatus.ACCEPTED);
        return response;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long productId, @RequestBody ProductDto newDetails)
    {
        Product product=productService.updateProduct(productId,newDetails);
        ResponseEntity<Product> response=new ResponseEntity<>(product,HttpStatus.ACCEPTED);
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") long productId)
    {
        boolean status=productService.deleteProduct(productId);
        ResponseEntity<Boolean> response;
        if(status) {
            response = new ResponseEntity<>(status, HttpStatus.ACCEPTED);
        }
        else
        {
            response =new ResponseEntity<>(status,HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
