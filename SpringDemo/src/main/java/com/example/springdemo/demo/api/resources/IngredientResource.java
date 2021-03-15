package com.example.springdemo.demo.api.resources;

import com.example.springdemo.demo.domains.Ingredient;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

public class IngredientResource extends RepresentationModel<IngredientResource> {

    @Getter
    private String name;
    @Getter
    private Ingredient.Type type;

    public IngredientResource(Ingredient ingredient){
        name=ingredient.getName();
        type=ingredient.getType();
    }


}
