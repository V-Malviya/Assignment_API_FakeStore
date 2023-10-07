package com.restapi.fakestoreapiproxy.inheritancePractice.Single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@Entity
@DiscriminatorValue(value = "1")
public class Instructor  extends User{
    private boolean isHandsome;
}
