package com.example.springdemo.demo.repositories;
import com.example.springdemo.demo.domains.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,String>{
}
