package com.example.springdemo.demo.controllers;
import com.example.springdemo.demo.domains.Order;
import com.example.springdemo.demo.utility.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session1=sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(order);

        session1.close();

        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
