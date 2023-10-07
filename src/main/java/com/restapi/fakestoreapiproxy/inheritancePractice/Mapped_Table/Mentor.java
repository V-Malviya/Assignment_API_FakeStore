package com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "Mapped_Mentor")
public class Mentor extends User{
    private int mentee;
    private int sessions;
}
