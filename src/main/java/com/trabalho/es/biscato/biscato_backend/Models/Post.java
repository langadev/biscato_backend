package com.trabalho.es.biscato.biscato_backend.Models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   @Column
   private String title;
   @Column
   private String content;
   @ManyToOne(fetch = FetchType.LAZY)
   @JsonBackReference
   @JoinColumn(name = "userID")
   private User user;
}

