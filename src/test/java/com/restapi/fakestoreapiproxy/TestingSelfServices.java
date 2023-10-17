package com.restapi.fakestoreapiproxy;

import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import com.restapi.fakestoreapiproxy.services.CategoryService;
import com.restapi.fakestoreapiproxy.services.ProductService;
import com.restapi.fakestoreapiproxy.services.implementation.SelfCategoryService;
import com.restapi.fakestoreapiproxy.services.implementation.SelfProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class TestingSelfServices {
    @Autowired
    SelfProductService productService;
    @Autowired
    SelfCategoryService categoryService;
    // working
    @Test
    void getAllProduct()
    {
        List<Product> list=productService.getAllProducts().get();
        for(Product p:list)
        {
            System.out.println(p.getTitle());
        }
    }
    // working
    @Test
    void getProductById()
    {
        Product p=productService.getProductById(3).get();
        System.out.println(p.getTitle());
    }
    // working
    @Test
    @Transactional
    @Rollback(value = false)
    void addProduct()
    {
        Product product=new Product();
        product.setTitle("product1");
        product.setPrice(4599);
        product.setImageUrl("mujheNahiPataUrl");
        Category category=new Category();
        category.setName("Jewelry");
        product.setCategory(category);
        productService.addNewProduct(product);
    }
    // working
    @Test
    void getAllCategories()
    {
        List<Category> categories=categoryService.getAllCategories().get();
        for(Category c:categories)
        {
            System.out.println(c.getName());
        }
    }
    // working
    @Test
    @Transactional
    void getAllProductInCategory()
    {
        List<Product> productList;
        productList = categoryService.getAllProductsInCategory("Jewelry").get();
        for(Product p:productList)
        {
            System.out.println(p.getTitle());
        }
    }
    //not working
    @Test
    @Transactional
    void updateProduct()
    {
        Product newProduct=new Product();
        newProduct.setPrice(-1000);
        Product product=productService.updateProduct(3l,newProduct).get();
        System.out.println(product.getTitle());
    }
    //not working
    @Test
    void deleteProduct()
    {
        boolean result= productService.deleteProduct(3l);
    }
}
