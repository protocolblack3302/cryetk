package com.harsh;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="people")

public class User {
    @Id
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Laptop> list=new ArrayList<>();

    public List<Laptop> getList() {
        return list;
    }

    public void setList(List<Laptop> list) {
        this.list = list;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
