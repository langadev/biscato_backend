package com.trabalho.es.biscato.biscato_backend.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.es.biscato.biscato_backend.Models.Post;
import com.trabalho.es.biscato.biscato_backend.Models.User;
import com.trabalho.es.biscato.biscato_backend.Repository.PostRepotory;
import com.trabalho.es.biscato.biscato_backend.Repository.UserRepository;
import com.trabalho.es.biscato.biscato_backend.dtos.CadastroPostDTO;

@Service
public class PostService {

    private final PostRepotory postRepotory;
    private final UserRepository userRepository;

    public PostService(PostRepotory postRepotory, UserRepository userRepository){
        this.postRepotory = postRepotory;
        this.userRepository = userRepository;
    }

    @Transactional
    public Post savePost(CadastroPostDTO postDTO) {
        Optional<User> userOptional = userRepository.findById(postDTO.userID());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Post post = new Post();
        post.setTitle(postDTO.title());
        post.setContent(postDTO.content()); // CORRIGIDO
        post.setUser(userOptional.get());

        return postRepotory.save(post);
    }

    public List<Post> findAllPosts() {
        return postRepotory.findAll();
    }

    public Optional<Post> findPostById(UUID id) {
        return postRepotory.findById(id);
    }

    @Transactional
    public Post updatePost(UUID id, CadastroPostDTO postDTO) {
        Optional<Post> optionalPost = postRepotory.findById(id);
        if (optionalPost.isEmpty()) {
            throw new RuntimeException("Post não encontrado");
        }

        Post post = optionalPost.get();
        post.setTitle(postDTO.title());
        post.setContent(postDTO.content());

        return postRepotory.save(post);
    }

    @Transactional
    public void deletePost(UUID id) {
        if (!postRepotory.existsById(id)) {
            throw new RuntimeException("Post não encontrado para deletar");
        }
        postRepotory.deleteById(id);
    }
}
