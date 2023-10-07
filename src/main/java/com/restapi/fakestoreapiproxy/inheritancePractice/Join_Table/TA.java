package com.restapi.fakestoreapiproxy.inheritancePractice.Join_Table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@Entity(name = "JT_TA")
@PrimaryKeyJoinColumn(name = "id")
public class TA extends User{
    private double rating;
}
