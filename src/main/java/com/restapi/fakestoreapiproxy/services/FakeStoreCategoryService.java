package com.restapi.fakestoreapiproxy.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryService implements CategoryService {
    @Override
    public String getAllCategories()
    {
        return "Return all categories :";
    }
    @Override
    public String getAllProductsInCategory(String category)
    {
        return "Return List of all products in category :"+category;
    }
}
