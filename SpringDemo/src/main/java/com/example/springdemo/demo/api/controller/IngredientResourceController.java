package com.example.springdemo.demo.api.controller;
import com.example.springdemo.demo.api.assembler.IngredientResourceAssembler;
import com.example.springdemo.demo.api.resources.IngredientResource;
import com.example.springdemo.demo.configurations.OrderProps;
import com.example.springdemo.demo.domains.Ingredient;
import com.example.springdemo.demo.repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path="/design/recent/ingredients",produces = "application/json")
@CrossOrigin(origins ="*")
@RequiredArgsConstructor
public class IngredientResourceController {
    private final IngredientRepository ingredientRepository;
    private final OrderProps orderProps;
    @GetMapping
    public CollectionModel<IngredientResource> getIngredient(){
        PageRequest pageRequest=PageRequest.of(0,orderProps.getPageSize()); //fetch 20 tacos list
        List<Ingredient> taco_list=ingredientRepository.findAll(pageRequest);
        CollectionModel<IngredientResource> collectionModel = new IngredientResourceAssembler().toCollectionModel(taco_list);
        collectionModel.add(linkTo(methodOn(IngredientResourceController.class).getIngredient()).withRel("ingredient"));
        return collectionModel;
    }



}
