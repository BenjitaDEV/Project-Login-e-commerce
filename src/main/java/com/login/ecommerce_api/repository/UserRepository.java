package com.login.ecommerce_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.ecommerce_api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //SELECT * FROM users WHERE username
    //sin escribir SQL directamente
    //Optional<user> sirve para poder ver si existe o no el user
    Optional<User> findByUsername(String username);
}
