package com.restapi.fakestoreapiproxy.services.implementation;

import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.repositories.ProductRepository;
import com.restapi.fakestoreapiproxy.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SelfProductService implements ProductService {
    ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
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
        return Optional.of(product);
//        return Optional.empty();
    }

    @Override
    public Optional<Product> addNewProduct(Product newProduct) {
        Product product=productRepository.save(newProduct);
        return Optional.of(product);
//        return Optional.empty();
    }

    @Override
    public Optional<Product> updateProduct(long productId, Product details) {
//        Product product=productRepository.updateById(productId,details);
//        return Optional.of(product);
        return Optional.empty();
    }

    @Override
    public Optional<Product> replaceProduct(long productId, Product details) {
        return Optional.empty();
    }

    @Override
    public boolean deleteProduct(long productId) {
        Product p=productRepository.deleteProductById(productId);
//        if(p==null)
//        {
//            return false;
//        }
        return true;
    }
}
