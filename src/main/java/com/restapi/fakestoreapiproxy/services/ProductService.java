package com.restapi.fakestoreapiproxy.services;

import com.restapi.fakestoreapiproxy.dtos.ProductDto;

public interface ProductService {
    String getAllProducts();

    String getProductById(long productId);

    String addNewProduct(ProductDto productDto);

    String updateProduct(long productId);

    String deleteProduct(long productId);
}
