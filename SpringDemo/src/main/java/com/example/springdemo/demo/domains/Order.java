package com.example.springdemo.demo.domains;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "tacoOrder")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @NotBlank(message = "cannot be empty")
    private String name;
    @NotBlank(message = "cannot be empty")
    private String street;
    @NotBlank(message = "cannot be empty")
    private String city;
    @NotBlank(message = "cannot be empty")
    private String state;
    @NotBlank(message = "cannot be empty")
    private String zip;
    @CreditCardNumber(message="Not valid card number")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$" ,message = "format should be mm/yy")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;
    @OneToMany(mappedBy = "tacoOrderId")
    List<Taco> tacoID;

}
