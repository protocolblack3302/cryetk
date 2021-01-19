package com.example.springdemo.demo.api.resources;

import com.example.springdemo.demo.api.assembler.IngredientResourceAssembler;
import com.example.springdemo.demo.domains.Taco;
import lombok.Getter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;


public class TacoResource extends RepresentationModel<TacoResource> {
    private static final IngredientResourceAssembler resourceAssembler=new IngredientResourceAssembler();
    @Getter
    public String taco_resource_name;
    @Getter
    public CollectionModel<IngredientResource> ingredientResources;
    public TacoResource(Taco taco){
        taco_resource_name=taco.getTaco_name();
        ingredientResources=resourceAssembler.toCollectionModel(taco.getIngredients());
    }
}
