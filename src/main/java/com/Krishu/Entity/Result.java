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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return TotalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        TotalQuestions = totalQuestions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", score=" + score +
                ", TotalQuestions=" + TotalQuestions +
                ", user=" + user +
                ", quiz=" + quiz +
                '}';
    }
}
