package com.restapi.fakestoreapiproxy.services.implementation;

import com.restapi.fakestoreapiproxy.exceptions.NoProductFoundException;
import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.repositories.CategoryRepository;
import com.restapi.fakestoreapiproxy.repositories.ProductRepository;
import com.restapi.fakestoreapiproxy.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SelfProductService implements ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Optional<List<Product>> getAllProducts() {
        List<Product> list=productRepository.findAll();
        return Optional.of(list);
//        return Optional.empty();
    }

    @Override
    public Optional<Product> getProductById(long productId) {
        Product product=productRepository.findProductById(productId);
        if(product==null)
        {
            return Optional.empty();
        }
        return Optional.of(product);
//        return Optional.empty();
    }

    @Override
    public Optional<Product> addNewProduct(Product newProduct) {
        Category category=categoryRepository.findCategoryByName(newProduct.getCategory().getName());
        if(category!=null)
        {
            newProduct.setCategory(category);
        }
        Product product=productRepository.save(newProduct);
        return Optional.of(product);
//        return Optional.empty();
    }

    @Override
    public Optional<Product> updateProduct(long productId, Product details) {
        if(!productRepository.existsById(productId)) {
            return Optional.empty();
        }
        Product dbProduct=productRepository.findProductById(productId);
        Category dbCategory=categoryRepository.findCategoryByName(details.getCategory().getName());
        if(dbCategory==null)
        {
            dbCategory=categoryRepository.save(details.getCategory());
        }
        details.setCategory(dbCategory);
        details.setId(productId);
        copy(dbProduct,details);
        Product product=productRepository.save(details);
        return Optional.of(product);
    }

    @Override
    public Optional<Product> replaceProduct(long productId, Product details) {
        return updateProduct(productId,details);
    }

    @Override
    public boolean deleteProduct(long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteProductById(productId);
            return true;
        }
        return false;
    }
    public static void copy(Product to,Product from)
    {
        to.setId(from.getId());
        to.setDescription(from.getDescription());
        to.setTitle(from.getTitle());
        to.setPrice(from.getPrice());
        to.setImageUrl(from.getImageUrl());
        to.setCategory(from.getCategory());
        to.setCreatedAt(from.getCreatedAt());
        to.setLastUpdatedAt(from.getLastUpdatedAt());
    }
}
