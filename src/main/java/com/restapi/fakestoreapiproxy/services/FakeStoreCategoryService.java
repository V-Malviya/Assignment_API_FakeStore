package com.restapi.fakestoreapiproxy.services;

import com.restapi.fakestoreapiproxy.models.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService {
    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Category> getAllCategories()
    {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<String[]> list=restTemplate
                .getForEntity("https://fakestoreapi.com/products/categories",String[].class);
        List<Category> ansList=new ArrayList<>();
        for(String s:list.getBody())
        {
            Category category=new Category();
            category.setName(s);
            ansList.add(category);
        }
        return ansList;
    }
    @Override
    public String getAllProductsInCategory(String category)
    {
        return "Return List of all products in category :"+category;
    }
}
