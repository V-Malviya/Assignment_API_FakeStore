package com.restapi.fakestoreapiproxy.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
