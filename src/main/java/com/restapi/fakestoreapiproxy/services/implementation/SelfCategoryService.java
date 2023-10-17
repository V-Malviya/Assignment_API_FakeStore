package com.restapi.fakestoreapiproxy.services.implementation;

import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.repositories.CategoryRepository;
import com.restapi.fakestoreapiproxy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SelfCategoryService implements CategoryService {
    CategoryRepository categoryRepository;
    SelfCategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Optional<List<Category>> getAllCategories() {
        List<Category> list=categoryRepository.findAll();
        return Optional.of(list);
//        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getAllProductsInCategory(String category) {
        List<Product> list=categoryRepository.findCategoryByName(category).getProducts();

        return Optional.of(list);
//        return Optional.empty();
    }
}
