package com.Krishu.DAO;

import com.Krishu.Entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public void saveUser(User user){
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        s.persist(user);
        transaction.commit();
    }

    public User getUserById(int id){
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        User user=s.find(User.class,id);
        transaction.commit();
        return user;
    }

    public int getIdByEmailAndPassword(String email, String Password) throws SQLException {
        String sql="select * from User where email=? and password=?";
        Connection connection=DBConnection.getConnection();
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setString(1,email);
        ps.setString(2,Password);
        ResultSet set=ps.executeQuery();
        if(set.next()){
            return set.getInt("id");
        }
        return -1;
    }
}
