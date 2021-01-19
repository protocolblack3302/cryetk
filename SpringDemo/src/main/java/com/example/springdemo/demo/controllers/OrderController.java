package com.example.springdemo.demo.controllers;
import com.example.springdemo.demo.domains.Order;
import com.example.springdemo.demo.domains.Taco;
import com.example.springdemo.demo.domains.Users;
import com.example.springdemo.demo.repositories.OrderRepository;
import com.example.springdemo.demo.repositories.TacoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor  //to initialize the final fields of the class
public class OrderController {
    private final TacoRepository tacoRepository;
    private final OrderRepository orderRepository;

    @GetMapping("/current")
    public String orderForm(Model model) {
        Order order=new Order();
        model.addAttribute("order",order);
        return "orderForm";
    }


    @PostMapping
    public String processOrder(@AuthenticationPrincipal Users user, @Valid @ModelAttribute(name="order") Order order , Errors errors ) {
        if(errors.hasErrors()){
            return "orderForm";
        }
        List<Taco> tacoList =tacoRepository.findAllByUser(user);
        order.setOrder_taco(tacoList);
        order.setUser(user);
        orderRepository.save(order);

        log.info("Order submitted: " + order);
        return "redirect:/design";


    }
}
