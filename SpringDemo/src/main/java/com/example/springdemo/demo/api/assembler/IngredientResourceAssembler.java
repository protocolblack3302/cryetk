package com.example.springdemo.demo.api.assembler;

import com.example.springdemo.demo.api.controller.IngredientResourceController;
import com.example.springdemo.demo.api.resources.IngredientResource;
import com.example.springdemo.demo.domains.Ingredient;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientResourceController.class,IngredientResource.class);
    }

    @Override
    public IngredientResource toModel(Ingredient entity) {
        return createModelWithId(entity.getId(),entity);
    }
}
