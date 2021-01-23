package com.example.springdemo.demo.domains;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Data
@RestResource(rel = "tacos",path = "tacos")
public class Taco implements Serializable {

    @Id
    @NotNull
    @NotBlank
    @Size(min = 5,message = "name must be 5 characters long")
    private String taco_name;
    @Size(min = 1,message = "there should be at least 1 ingredient")
    @OneToMany
    private List<Ingredient> ingredients= new ArrayList<>();
    @ManyToOne
    private Users user;


}
