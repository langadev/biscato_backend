package com.trabalho.es.biscato.biscato_backend.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.es.biscato.biscato_backend.Models.Post;

public interface PostRepotory extends JpaRepository<Post,UUID> {
    
}
