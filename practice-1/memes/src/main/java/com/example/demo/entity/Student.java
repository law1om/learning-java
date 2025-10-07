package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int score;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "reaction_id")
    private GradeReaction reaction;

    public Student() {}

    public Student(String name, int score, String imageUrl, GradeReaction reaction) {
        this.name = name;
        this.score = score;
        this.imageUrl = imageUrl;
        this.reaction = reaction;
    }

    // --- Getters и Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public GradeReaction getReaction() { return reaction; }
    public void setReaction(GradeReaction reaction) { this.reaction = reaction; }
}
