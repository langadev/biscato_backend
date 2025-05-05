package com.trabalho.es.biscato.biscato_backend.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.es.biscato.biscato_backend.Models.User;
import com.trabalho.es.biscato.biscato_backend.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(UUID id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setFullName(updatedUser.getFullName());
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setProfileImageUrl(updatedUser.getProfileImageUrl());
            user.setBio(updatedUser.getBio());
            user.setLocation(updatedUser.getLocation());
            user.setProfession(updatedUser.getProfession());
            user.setSkills(updatedUser.getSkills());
            return userRepository.save(user);
        });
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
