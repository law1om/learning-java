package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class GradeReaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String imageUrl;

    public GradeReaction() {}

    public GradeReaction(String description, String imageUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // --- Getters и Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
