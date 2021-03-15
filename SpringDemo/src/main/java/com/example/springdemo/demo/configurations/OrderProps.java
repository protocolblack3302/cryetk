package com.example.springdemo.demo.configurations;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "springdemo.orders")
@Data
public class OrderProps {
   private int pageSize=12;
}
