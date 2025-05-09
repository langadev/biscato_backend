package com.trabalho.es.biscato.biscato_backend.dtos;

import java.util.UUID;

import com.trabalho.es.biscato.biscato_backend.Models.Post;

public record CadastroPostDTO(
    String title,
    String content,
    UUID userID
) {
    public Post toPost(){
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        return post;
    }
    
}
