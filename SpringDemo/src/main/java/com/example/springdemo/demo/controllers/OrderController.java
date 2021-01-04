package com.example.springdemo.demo.controllers;
import com.example.springdemo.demo.domains.Order;
import com.example.springdemo.demo.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order , Errors errors) {
        if(errors.hasErrors()){
            return "orderForm";
        }
        orderRepository.save(order);
        log.info("Order submitted: " + order);
        return "redirect:/design";




    }
}
