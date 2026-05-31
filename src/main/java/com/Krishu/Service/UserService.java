package com.Krishu.Service;

import com.Krishu.DAO.ResultDAO;
import com.Krishu.DAO.UserDAO;
import com.Krishu.Entity.User;
import com.Krishu.Entity.Result;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final static UserDAO user_dao=new UserDAO();
    private final static ResultDAO result_dao=new ResultDAO();

    public static void RegisterUser(String name,String email,String password){
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user_dao.saveUser(user);
    }

    public static User LoginUser(String email,String password) throws SQLException {
        int user_id=user_dao.getIdByEmailAndPassword(email,password);
        User user= user_dao.getUserById(user_id);
        if(user==null){
            return null;
        }
        return user;
    }

    public static void showProfile(int user_id){
        User user=user_dao.getUserById(user_id);
        System.out.println("User id: "+user.getId());
        System.out.println("User Name: "+user.getName());
        System.out.println("User Email: "+user.getEmail());
        System.out.println("User Password: "+user.getPassword());
    }

    public void getAttemptsHistory(int user_id){
        List<Result> results=result_dao.getResultByUser(user_id);
        for(Result result:results){
            System.out.println("************************************************");
            System.out.println("Quiz Title: "+result.getQuiz().getTitle());
            System.out.println("Score: "+result.getScore());
            System.out.println("Total Questions: "+result.getTotalQuestions());
        }
    }
}
