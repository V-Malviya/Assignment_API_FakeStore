package com.restapi.fakestoreapiproxy.inheritancePractice.Join_Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "JT_Mentor")
@PrimaryKeyJoinColumn(name="id")
public class Mentor extends User{
    private int mentee;
    private int sessions;
}
