package com.Krishu;

import com.Krishu.Entity.User;
import com.Krishu.Service.AttemptService;
import com.Krishu.Service.QuizService;
import com.Krishu.Service.UserService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class AllServiceTest {
    //QuizService
    //*****************************************************
    @Test
    public void addQuizTest(){
        QuizService.createNewQuiz("Java Advance","OOPs,JDBC,Servlet,Hibernate,Spring");
    }

    @Test
    public void AddQuestionToQuizTest(){
        QuizService.AddQuestionInQuiz(1,"Its question no.1","a","b","c","d","Answer is none of these");
    }

    @Test
    public void ShowQuizTest(){
        QuizService.ShowQuiz(2);
    }
    //********************************************************

    //UserService
    //********************************************************

    @Test
    public void RegisterUserTest(){
        UserService.RegisterUser("Santosh","Santosh@123gmail.com","G%erc123&yu");
    }

    @Test
    public void LoginUserTest() throws SQLException {
        User user=UserService.LoginUser("Santosh@123gmail.com","G%erc123&yu");
        System.out.println(user);
    }

    @Test
    public void ShowResultHistory(){
        UserService.getAttemptsHistory(1);
    }

    @Test
    public void ShowProfileTest(){
        UserService.showProfile(1);
    }

    //***********************************************************

}
