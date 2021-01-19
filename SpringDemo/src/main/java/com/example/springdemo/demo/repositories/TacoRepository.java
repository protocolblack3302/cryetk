package com.example.springdemo.demo.repositories;

import com.example.springdemo.demo.domains.Order;
import com.example.springdemo.demo.domains.Taco;
import com.example.springdemo.demo.domains.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TacoRepository extends CrudRepository<Taco,String> {
    List<Taco> findAll(Pageable pageable);
    List<Taco> findAllByUser(@AuthenticationPrincipal Users user);


}
