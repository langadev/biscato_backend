package com.trabalho.es.biscato.biscato_backend.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.es.biscato.biscato_backend.Models.Post;
import com.trabalho.es.biscato.biscato_backend.Services.PostService;
import com.trabalho.es.biscato.biscato_backend.dtos.CadastroPostDTO;

@RequestMapping("biscato/api/v1/posts")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    // CREATE
    @PostMapping
    public ResponseEntity<Object> savePost(@RequestBody CadastroPostDTO cadastroPostDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(cadastroPostDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // READ ALL
    @GetMapping
     @JsonIgnore
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.findAllPosts());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable UUID id) {
        Optional<Post> postOptional = postService.findPostById(id);
        return postOptional
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable UUID id, @RequestBody CadastroPostDTO dto) {
        try {
            Post updated = postService.updatePost(id, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable UUID id) {
        try {
            postService.deletePost(id);
            return ResponseEntity.ok("Post deletado com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
