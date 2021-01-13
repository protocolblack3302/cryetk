package com.example.springdemo.demo.repositories;
import com.example.springdemo.demo.domains.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {


    Optional<Users> findUsersByUsername(String username);
}
