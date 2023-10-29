package com.restapi.fakestoreapiproxy.controllers;

import com.restapi.fakestoreapiproxy.clients.FakeStoreClient.FakeStoreProductResponseDto;
import com.restapi.fakestoreapiproxy.dtos.ErrorResponseDto;
import com.restapi.fakestoreapiproxy.dtos.ProductRequestDto;
import com.restapi.fakestoreapiproxy.dtos.ProductResponseDto;
import com.restapi.fakestoreapiproxy.exceptions.NoProductFoundException;
import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    ProductController(@Qualifier(value = "selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() throws NoProductFoundException {
        List<ProductResponseDto> anslist = new ArrayList<>();
        ResponseEntity<List<ProductResponseDto>> responseEntity;
        Optional<List<Product>> optionalList = productService.getAllProducts();
        if (optionalList.isEmpty()) {
            throw new NoProductFoundException("There are no product added in database ");
        }
        List<Product> list = optionalList.get();
        for (Product p : list) {
            anslist.add(productToResponseDto(p));
        }
        return new ResponseEntity<>(anslist, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") long productId) throws NoProductFoundException {
        // ideally we should have a proper ProductResponseDto and ProductRequestDto but here we are returning
        // product in response body of response entity.
        Optional<Product> optionalProduct = productService.getProductById(productId);
        if (optionalProduct.isEmpty()) {
            throw new NoProductFoundException("no product is available with id :" + productId); //since
            // this method is exposing my inner details to client via trace so create a response entity
            // with errorResponseDto
        }
        Product product = optionalProduct.get();
        ProductResponseDto responseDto = productToResponseDto(product);
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("auth-token", "Nirlaj_tu_phir_agaya XD");
        System.out.println(product.toString());
//        ResponseEntity<Product> response=new ResponseEntity<>(product,header,HttpStatus.NOT_MODIFIED);
//        return response;
        ResponseEntity<ProductResponseDto> response = new ResponseEntity<>(responseDto, header, HttpStatus.OK);
        return response;
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> addNewProduct(@RequestBody ProductRequestDto productDto) throws NoProductFoundException {
        Optional<Product> optionalProduct = productService.addNewProduct(requestDtoToProduct( productDto));
        if (optionalProduct.isEmpty()) {
            throw new NoProductFoundException("Sorry unable to add product");
        }
        Product product = optionalProduct.get();
        ResponseEntity<ProductResponseDto> response = new ResponseEntity<>(productToResponseDto(product), HttpStatus.ACCEPTED);
        return response;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("id") long productId, @RequestBody ProductRequestDto newDetails)
    throws NoProductFoundException{
        Optional<Product> optionalProduct = productService.updateProduct(productId, requestDtoToProduct( newDetails));
        if (optionalProduct.isEmpty()) {
            throw new NoProductFoundException("Sorry unable to update product with id :"+productId+" as it doesn't exist");
        }
        ResponseEntity<ProductResponseDto> response = new ResponseEntity<>(productToResponseDto(optionalProduct.get()), HttpStatus.ACCEPTED);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> replaceProduct(@PathVariable("id") long productId, @RequestBody ProductRequestDto newDetails)
    throws NoProductFoundException{
        Optional<Product> optionalProduct = productService.replaceProduct(productId, requestDtoToProduct( newDetails));
        if (optionalProduct.isEmpty()) {
            throw new NoProductFoundException("Sorry unable to replace product with id :"+productId);
        }
        ResponseEntity<ProductResponseDto> response = new ResponseEntity<>(productToResponseDto(optionalProduct.get()), HttpStatus.ACCEPTED);
        return response;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") long productId) {
        boolean status = productService.deleteProduct(productId);
        ResponseEntity<Boolean> response;
        if (status) {
            response = new ResponseEntity<>(status, HttpStatus.ACCEPTED);
        } else {
            response = new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
        }
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
    private Product requestDtoToProduct(ProductRequestDto requestDto)
    {
        Product product=new Product();
        product.setTitle(requestDto.getTitle());
        product.setPrice(requestDto.getPrice());
        product.setImageUrl(requestDto.getImage());
        Category category=new Category();
        category.setName(requestDto.getCategory());
        product.setCategory(category);
        product.setDescription(requestDto.getDescription());
        return product;
    }
    /*1st way:
    * One way is to handle exception getting sent via controller to client is to create a separate
    * method in controller class that handles exception and returns a response body with exception message
    * as a string
    * */
//@ExceptionHandler(NoProductFoundException.class)
//    private ResponseEntity<ErrorResponseDto> exceptionHandlerForNoProductFound(NoProductFoundException exception)
//    {
//        ErrorResponseDto entity =new ErrorResponseDto();
//        entity.setMessage(exception.getMessage());
//
//        return new ResponseEntity<>(entity,HttpStatus.OK);
//    }
}
