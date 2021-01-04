package com.example.springdemo.demo.repositories;

import com.example.springdemo.demo.domains.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends CrudRepository<Taco,String> {
}
