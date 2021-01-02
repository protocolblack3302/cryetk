package com.example.springdemo.demo.domains;
import lombok.Data;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;



@Entity
@Data
@Table(name="taco")
public class Taco {

    @NotNull
    @NotBlank
    @Size(min = 5,message = "name must be 5 characters long")
    @Id
    @Column(name="name")
    private String name;
    @Size(min = 1,message = "there should be at least 1 ingredient")
    @ElementCollection
    @Column(name="ingredients")
    private List<String> ingredients;

}
