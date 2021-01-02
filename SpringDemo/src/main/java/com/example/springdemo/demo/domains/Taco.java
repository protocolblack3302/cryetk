package com.example.springdemo.demo.domains;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "Taco")
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Taco {
    @NotNull
    @NotBlank
    @Size(min = 5,message = "name must be 5 characters long")
    @Id
    private String name;
    @Size(min = 1,message = "there should be at least 1 ingredient")
    @OneToMany
    private List<String> ingredients;
}
