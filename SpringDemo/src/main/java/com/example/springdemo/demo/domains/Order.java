package com.example.springdemo.demo.domains;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;



@Entity
@Data
@Table
public class Order {
    @Id
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
}
