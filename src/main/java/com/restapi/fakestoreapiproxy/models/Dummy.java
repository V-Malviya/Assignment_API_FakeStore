package com.restapi.fakestoreapiproxy.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dummy extends BaseModel{
    private String name;
}
