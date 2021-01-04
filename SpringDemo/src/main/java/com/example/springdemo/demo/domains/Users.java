package com.example.springdemo.demo.domains;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
public class Users {
  @Id
  @Column(name="username",nullable = false)
    private String username;
  @Column(name="password",nullable = false)
  private String password;
  @Column(name="enabled",nullable = false,columnDefinition = "boolean default true")
  private Boolean enabled=true;


}
