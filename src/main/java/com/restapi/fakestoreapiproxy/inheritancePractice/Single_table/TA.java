package com.restapi.fakestoreapiproxy.inheritancePractice.Single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@Entity
@DiscriminatorValue(value = "3")
public class TA extends User{
    private double rating;
}
