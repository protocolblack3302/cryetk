package com.example.springdemo.demo.repositories;
import com.example.springdemo.demo.domains.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,String>{
}
