package com.restapi.fakestoreapiproxy.inheritancePractice.Join_Table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "JT_User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // changing auto to Identity as jpa buddy unable to create user_seq table for it
    private long id;
    private String name;
    private String email;
}
