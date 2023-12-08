package com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "TPC_TA")
public class TA extends User{
    private double rating;
}
