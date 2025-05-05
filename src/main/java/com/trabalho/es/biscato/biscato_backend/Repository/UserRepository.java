package com.trabalho.es.biscato.biscato_backend.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.es.biscato.biscato_backend.Models.User;

public interface UserRepository extends JpaRepository<User, UUID>{

    Optional<User> findByUsername(String username);
    
}