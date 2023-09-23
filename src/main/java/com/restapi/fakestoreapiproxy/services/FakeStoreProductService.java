package com.restapi.fakestoreapiproxy.services;

import com.restapi.fakestoreapiproxy.dtos.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public String getAllProducts()
    {
        return "Returning all products";
    }
    @Override
    public String getProductById(long productId)
    {
        return "Returning product wit id :"+productId;
    }
    @Override
    public String addNewProduct(ProductDto productDto)
    {
        return "Adding new Product with id :"+productDto.toString();
    }
    @Override
    public String updateProduct(long productId)
    {
        return "Updating product wit id"+productId;
    }
    @Override
    public String deleteProduct(long productId)
    {
        return "Deleting product wit id :"+productId;
    }
}
