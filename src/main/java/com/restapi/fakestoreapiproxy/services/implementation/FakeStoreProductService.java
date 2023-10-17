package com.restapi.fakestoreapiproxy.services.implementation;

import com.restapi.fakestoreapiproxy.clients.FakeStoreClient.FakeStore;
import com.restapi.fakestoreapiproxy.clients.FakeStoreClient.FakeStoreProductResponseDto;
import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.services.ProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

//@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStore fakeStore;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder, FakeStore fakeStore) {
        this.fakeStore=fakeStore;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public Optional<List<Product>> getAllProducts()
    {
        List<Product> products=fakeStore.getAllProducts();
        return  Optional.of(products);
    }
    @Override
    public Optional<Product> getProductById(long productId)
    {
        Product product=fakeStore.getProductById(productId);
        if(product==null)
        {
            return Optional.empty();
        }
        return Optional.of(product);
    }
    @Override
    public Optional<Product> addNewProduct(Product newProduct)
    {

        Product product=fakeStore.addNewProduct(newProduct);
        if(product==null)
        {
            return Optional.empty();
        }
        return Optional.of(product);
    }
    @Override
    public Optional<Product> updateProduct(long productId, Product details)
    {
        Product product=fakeStore.updateProduct(productId,details);
        if(product==null)
        {
            return Optional.empty();
        }
        return Optional.of(product);
    }

    @Override
    public Optional<Product> replaceProduct(long productId, Product details) {
        Product product=fakeStore.replaceProduct(productId,details);
        if(product==null)
        {
            return Optional.empty();
        }
        return Optional.of(product);
    }

    @Override
    public boolean deleteProduct(long productId)
    {
        Product product=fakeStore.deleteProduct(productId);
        if(product==null)
        {
            return false;
        }
        return true;
    }
}
