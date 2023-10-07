package com.restapi.fakestoreapiproxy.inheritancePractice.Join_Table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@Entity(name = "JT_Instructor")
@PrimaryKeyJoinColumn(name="id")
public class Instructor extends User{
    private boolean isHandsome;
}
