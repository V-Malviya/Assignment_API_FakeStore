package com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "TPC_Instructor")
public class Instructor extends User{
    private boolean isHandsome;
}
