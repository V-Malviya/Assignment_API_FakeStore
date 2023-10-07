package com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Mapped_Instructor")
public class Instructor extends User{
    private boolean isHandsome;
}
