package com.example.springdemo.demo.controllers;
import java.util.Arrays;
import java.util.List;
import com.example.springdemo.demo.domains.Ingredient;
import com.example.springdemo.demo.domains.Taco;
import com.example.springdemo.demo.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

import static java.util.stream.Collectors.toList;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    ingredients.stream().filter(t->t.getType()==type).collect(toList()));
        }
        model.addAttribute("design", new Taco());
        return "design";


    }
    @PostMapping
    public String processDesign(@Valid Taco design , Errors errors) {
        // Save the taco design...
        if(errors.hasErrors()){
            return "design";
        }

        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session1=sessionFactory.openSession();
        Transaction trx=session1.beginTransaction();
        session1.save(design);
        trx.commit();
        session1.close();

        // We'll do this in chapter 3
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }


}