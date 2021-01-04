package com.example.springdemo.demo.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Authorities {
    private String username;
    @Column(nullable = false,columnDefinition = "varchar(20) default 'ROLE_USER'")
    private final String authority="ROLE_USER";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
