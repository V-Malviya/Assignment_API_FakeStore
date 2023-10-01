package com.restapi.fakestoreapiproxy.services;

import com.restapi.fakestoreapiproxy.clients.FakeStoreClient.FakeStoreProductResponseDto;
import com.restapi.fakestoreapiproxy.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<List<Product>> getAllProducts();

    Optional<Product> getProductById(long productId);

    Optional<Product> addNewProduct(Product newProduct);

    Optional<Product> updateProduct(long productId, Product details);
    Optional<Product> replaceProduct(long productId,Product details);

    boolean deleteProduct(long productId);
}
