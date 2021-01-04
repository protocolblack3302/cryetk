package com.example.springdemo.demo.repositories;
import com.example.springdemo.demo.domains.Authorities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authorities,String>{
}
