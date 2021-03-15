package com.example.springdemo.demo.repositories;

import com.example.springdemo.demo.domains.Order;
import com.example.springdemo.demo.domains.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {
    @Override
    Optional<Order> findById(Integer integer);
    List<Order> findAllByUser(Pageable pageSize ,Users user);

}
