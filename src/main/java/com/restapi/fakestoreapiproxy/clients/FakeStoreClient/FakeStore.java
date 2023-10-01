package com.restapi.fakestoreapiproxy.clients.FakeStoreClient;


import com.restapi.fakestoreapiproxy.models.Category;
import com.restapi.fakestoreapiproxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FakeStore {
    RestTemplateBuilder restTemplateBuilder;

    public FakeStore(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    // Creating a more generic method that will call all GET,POST,PUT,UPDATE,DELETE by coping code get for entity
    // of common low level method i.e, execute method
    private <T> ResponseEntity<T> myRequestForEntity(HttpMethod method,String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        //doing this because base version in rest template don't support patch so add dependency in pom.xml of
        //HttpComponentsClientHttpRequestFactory from maven repo. and get latest
        RestTemplate restTemplate=restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
//        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, method, requestCallback, responseExtractor, uriVariables);
    }


    public List<Product> getAllProducts()
    {
        //Old way:
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<ProductResponseDto[]> response=restTemplate
//                .getForEntity("https://fakestoreapi.com/products",ProductResponseDto[].class);
//        List<ProductResponseDto> productResponseDtolist= Arrays.asList(response.getBody());
//        List<Product> ansList=new ArrayList<>();
//        for(ProductResponseDto p: productResponseDtolist) {
//            ansList.add(dtoToProductModel(p));
//        }
//        return Optional.of(ansList);

        //new way:
        ResponseEntity<FakeStoreProductResponseDto[]> response=myRequestForEntity(
                HttpMethod.GET,
                "https://fakestoreapi.com/products",
                null,
                FakeStoreProductResponseDto[].class,
                0); //null is not supported so puting 0 ;
        List<FakeStoreProductResponseDto> productResponseDtolist= Arrays.asList(response.getBody());
        List<Product> ansList=new ArrayList<>();
        for(FakeStoreProductResponseDto p: productResponseDtolist) {
            ansList.add(dtoToProductModel(p));
        }
        return ansList;
    }

    public Product getProductById(long productId)
    {
        //Old way:
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<ProductResponseDto> response=restTemplate
//                .getForEntity("https://fakestoreapi.com/products/{id}",ProductResponseDto.class,productId);
//        ProductResponseDto productResponseDto=response.getBody();
//        Product product=dtoToProductModel(productResponseDto);
//        return Optional.of(product);
        //New way:
        ResponseEntity<FakeStoreProductResponseDto> response=myRequestForEntity(
                HttpMethod.GET,
                "https://fakestoreapi.com/products/{id}",
                null,
                FakeStoreProductResponseDto.class,
                productId);
        FakeStoreProductResponseDto productResponseDto=response.getBody();
        Product product=dtoToProductModel(productResponseDto);
        return product;
    }

    public Product addNewProduct(Product product)
    {
        ResponseEntity<FakeStoreProductResponseDto> response=myRequestForEntity(
                HttpMethod.POST,
            "https://fakestoreapi.com/products",
                productToRequestDto(product),
                FakeStoreProductResponseDto.class,
                0       //again putting zero here as null not allowed
                );
        return dtoToProductModel(response.getBody());

    }

    public Product updateProduct(long productId, Product details)
    {
        ResponseEntity<FakeStoreProductResponseDto> response=myRequestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                productToRequestDto(details),
                FakeStoreProductResponseDto.class,
                productId
        );
        return dtoToProductModel(response.getBody());
    }

    public Product replaceProduct(long productId, Product details)
    {
        ResponseEntity<FakeStoreProductResponseDto> response= myRequestForEntity(
                HttpMethod.PUT,
                "https://fakestoreapi.com/products/{id}",
                productToRequestDto(details),
                FakeStoreProductResponseDto.class,
                productId
        );
        return dtoToProductModel(response.getBody());
    }
    public Product deleteProduct(long productId)
    {
        ResponseEntity<FakeStoreProductResponseDto> response=myRequestForEntity(
                HttpMethod.DELETE,
                "https://fakestoreapi.com/products/{id}",
                null,
                FakeStoreProductResponseDto.class,
                productId
        );
        return dtoToProductModel(response.getBody());
    }
    public List<Category> getAllCategory()
    {
        ResponseEntity<String[]> response=myRequestForEntity(
                HttpMethod.GET,
                "https://fakestoreapi.com/products/categories",
                null,
                String[].class,
                0   //putting zero as null not allowed
        );
        List<Category>categoryList=new ArrayList<>();
        for(String name: response.getBody())
        {
            categoryList.add(stringToCategory(name));
        }
        return categoryList;
    }
    public List<Product> getProductsInSpecificCategory(String category)
    {
        ResponseEntity<FakeStoreProductResponseDto[]> response=myRequestForEntity(
                HttpMethod.GET,
                "https://fakestoreapi.com/products/category/{nameOfCategory}",
                null,
                FakeStoreProductResponseDto[].class,
                category
        );
        List<Product> productList=new ArrayList<>();
        for (FakeStoreProductResponseDto p:response.getBody())
        {
            productList.add(dtoToProductModel(p));
        }
        return productList;
    }
    private Product dtoToProductModel(FakeStoreProductResponseDto dto)
    {
        if(dto==null)
        {
            return null;
        }
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
    private FakeStoreProductRequestDto productToRequestDto(Product product)
    {
        FakeStoreProductRequestDto requestDto=new FakeStoreProductRequestDto();
        requestDto.setTitle(product.getTitle());
        requestDto.setPrice(product.getPrice());
        requestDto.setDescription(product.getDescription());
        requestDto.setImage(product.getImageUrl());
        requestDto.setCategory(product.getCategory().getName());
        return requestDto;
    }
    private Category stringToCategory(String name)
    {
        Category category=new Category();
        category.setName(name);
        return category;
    }
}
