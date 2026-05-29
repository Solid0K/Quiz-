package com.Krishu.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String topic;

    @OneToMany(mappedBy="quiz")
    List<Question> ques;

    public void setTitle(String title){
        this.title=title;
    }

    public void setTopic(String topic){
        this.topic=topic;
    }

    public List<Question> getQuestionList(){
        return ques;
    }

    public String getTitle(){
        return this.title;
    }

    public String getTopic(){
        return this.topic;
    }
}
