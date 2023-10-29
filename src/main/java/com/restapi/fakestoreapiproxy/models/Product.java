package com.restapi.fakestoreapiproxy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@Entity()
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    private String imageUrl;
    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
}
