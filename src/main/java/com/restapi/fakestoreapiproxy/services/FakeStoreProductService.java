package com.restapi.fakestoreapiproxy.services;

import com.restapi.fakestoreapiproxy.dtos.ProductDto;
import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductDto[] getAllProducts()
    {
//         gettting reponse entity
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> response=restTemplate
                .getForEntity("https://fakestoreapi.com/products",ProductDto[].class);
//        System.out.println(response.getBody());
//        List<Product> list=response.getBody();
        return response.getBody();
    }
    @Override
    public Product getProductById(long productId)
    {
        //Getting response from 3rd party Api
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto> response=restTemplate
                .getForEntity("https://fakestoreapi.com/products/{id}",ProductDto.class,productId);
        // getting json of product that will come from Api
        ProductDto responseProduct=response.getBody();
        Product ans=this.dtoToModel(responseProduct);
        return ans;
    }
    @Override
    public Product addNewProduct(ProductDto productDto)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto> response=restTemplate
                .postForEntity("https://fakestoreapi.com/products",productDto,ProductDto.class);
        ProductDto responseProduct=response.getBody();
        Product ans=this.dtoToModel(responseProduct);
        return ans;
    }
    @Override
    public Product updateProduct(long productId,ProductDto details)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        HttpEntity<ProductDto> entity=new HttpEntity<>(details);
        ResponseEntity<ProductDto> response=restTemplate
                .exchange("https://fakestoreapi.com/products"+"/"+productId,HttpMethod.PUT,entity,new ParameterizedTypeReference<ProductDto>(){});
        ProductDto responseProduct=response.getBody();
        Product ans=this.dtoToModel(responseProduct);
        return ans;
    }
    @Override
    public boolean deleteProduct(long productId)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto> response=restTemplate
                .exchange("https://fakestoreapi.com/products"+"/"+productId,HttpMethod.DELETE,null,new ParameterizedTypeReference<ProductDto>(){});
        ProductDto product=response.getBody();
        if(product.getId()==productId)
        {
            return true;
        }
        return false;
    }
    private Product dtoToModel(ProductDto dto)
    {
        Product ans=new Product();
        ans.setId(dto.getId());
        ans.setTitle(dto.getTitle());
        ans.setPrice(dto.getPrice());
        ans.setDescription(dto.getDescription());
        ans.setImageUrl(dto.getImage());
        Category category=new Category();
        category.setName(dto.getCategory());
        ans.setCategory(category);
        return ans;
    }
}
