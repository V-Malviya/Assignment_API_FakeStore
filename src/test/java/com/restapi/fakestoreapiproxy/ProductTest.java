package com.restapi.fakestoreapiproxy;

import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.repositories.CategoryRepository;
import com.restapi.fakestoreapiproxy.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ProductTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    @Transactional
    @Rollback(value = false)
    void createProductAndCategory()
    {
        // create random data in database by altering param passed
        Category category=new Category();
        category.setName("Electronics");
        category.setDescription("these category contains Electronic");
//        categoryRepository.save(category);

        Product product=new Product();
        product.setTitle("Cell_Phone_1");
        product.setImageUrl("image@xyz.com");
        product.setPrice(10000);
        product.setCategory(category);
        productRepository.save(product);

    }
    @Test
    void testOneToMany()
    {

    }
}
