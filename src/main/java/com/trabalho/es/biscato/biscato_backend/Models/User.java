package com.trabalho.es.biscato.biscato_backend.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


import jakarta.persistence.Column;

@Getter
@Setter
@Entity(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column
    private String phone;
    @Column
    private String profileImageUrl;
    @Column
    private String bio;
    @Column
    private String location;
    @Column
    private String profession;
    @Column
    private String skills;
    @Column
    private Double pricePerHour;
}
