package com.restapi.fakestoreapiproxy.clients.FakeStoreClient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter@ToString
public class FakeStoreProductResponseDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingDto rating;
}
