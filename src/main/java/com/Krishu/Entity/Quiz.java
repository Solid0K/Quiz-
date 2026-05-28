package com.Krishu.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Quiz {
    @Id
    private int id;
    private String title;
    private String topic;

    @OneToMany(mappedBy="quiz")
    List<Question> ques;
}
