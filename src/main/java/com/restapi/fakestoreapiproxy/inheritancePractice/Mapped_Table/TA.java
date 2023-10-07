package com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "Mapped_TA")
public class TA extends User{
    private double rating;
}
