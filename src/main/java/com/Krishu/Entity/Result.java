package com.Krishu.Entity;

import jakarta.persistence.*;

@Entity
public class Result {
    @Id
    @GeneratedValue
    private int id;
    private int score;
    private int TotalQuestions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
