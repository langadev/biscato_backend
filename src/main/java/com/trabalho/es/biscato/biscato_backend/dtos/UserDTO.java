package com.trabalho.es.biscato.biscato_backend.dtos;

import com.trabalho.es.biscato.biscato_backend.Models.User;

public record UserDTO(
    String fullName,
    String username,
    String email,
    String phone,
    String profileImageUrl,
    String bio,
    String location,
    String profession,
    String skills
) {
    public User toUser() {
        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setProfileImageUrl(profileImageUrl);
        user.setBio(bio);
        user.setLocation(location);
        user.setProfession(profession);
        user.setSkills(skills);
        return user;
    }
}
