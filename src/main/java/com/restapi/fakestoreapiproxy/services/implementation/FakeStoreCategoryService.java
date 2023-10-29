package com.restapi.fakestoreapiproxy.services.implementation;

import com.restapi.fakestoreapiproxy.clients.FakeStoreClient.FakeStore;
import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.services.CategoryService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreCategoryService implements CategoryService {
    RestTemplateBuilder restTemplateBuilder;
    FakeStore fakeStore;
    public FakeStoreCategoryService(RestTemplateBuilder restTemplateBuilder,FakeStore fakeStore) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStore=fakeStore;
    }

    @Override
    public Optional<List<Category>> getAllCategories()
    {
        List<Category> categoryList=fakeStore.getAllCategory();
        if(categoryList.isEmpty())
        {
            return Optional.empty();
        }
        return Optional.of(categoryList);
    }
    @Override
    public Optional<List<Product>> getAllProductsInCategory(String category)
    {
        List<Product> list=fakeStore.getProductsInSpecificCategory(category);
        if(list.isEmpty())
        {
            return Optional.empty();
        }
        return Optional.of(list);
    }
}
