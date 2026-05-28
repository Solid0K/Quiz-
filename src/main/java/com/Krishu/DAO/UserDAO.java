package com.Krishu.DAO;

import com.Krishu.Entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
    public void saveUser(User user){
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        s.persist(user);
        transaction.commit();
        s.close();
    }

    public User getUserById(int id){
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        User user=s.find(User.class,id);
        transaction.commit();
        s.close();
        return user;
    }
}
