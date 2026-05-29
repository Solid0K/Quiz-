package com.Krishu.Entity;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private int Id;
    private String quesText;
    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;
    private String correctOption;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public void setQuesText(String quesText){
        this.quesText=quesText;
    }

    public void setOptionA(String optionA){
        this.option_A=optionA;
    }

    public void setOptionB(String optionB){
        this.option_B=optionB;
    }

    public void setOptionC(String optionC){
        this.option_C=optionC;
    }

    public void setOptionD(String optionD){
        this.option_D=optionD;
    }

    public void setCorrectOption(String CorrectOption){
        this.correctOption=CorrectOption;
    }

    public void setQuiz(Quiz quiz){
        this.quiz=quiz;
    }

    public String getQuestionText(){
        return this.quesText;
    }

    public String getOption_A() {
        return option_A;
    }

    public String getOption_B() {
        return option_B;
    }

    public String getOption_C() {
        return option_C;
    }

    public String getOption_D() {
        return option_D;
    }

    public String getCorrectOption() {
        return correctOption;
    }
}
