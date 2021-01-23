package com.example.springdemo.demo.api.resources;
import com.example.springdemo.demo.domains.Ingredient;
import com.example.springdemo.demo.domains.Taco;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;


public class TacoResource extends RepresentationModel<TacoResource> {
    @Getter
    public String taco_resource_name;
    @Getter
    public List<Ingredient> ingredientlist;
    public TacoResource(Taco taco){
        taco_resource_name=taco.getTaco_name();
        ingredientlist=taco.getIngredients();
    }
}
