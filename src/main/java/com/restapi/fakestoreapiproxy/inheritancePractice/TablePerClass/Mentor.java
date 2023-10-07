package com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_Mentor")
public class Mentor extends  User{
    private int mentee;
    private int sessions;
}
