package com.restapi.fakestoreapiproxy.services;

import com.restapi.fakestoreapiproxy.dtos.ProductDto;
import com.restapi.fakestoreapiproxy.models.Product;

import java.util.List;

public interface ProductService {
    ProductDto[] getAllProducts();

    Product getProductById(long productId);

    Product addNewProduct(ProductDto productDto);

    Product updateProduct(long productId,ProductDto details);

    boolean deleteProduct(long productId);
}
