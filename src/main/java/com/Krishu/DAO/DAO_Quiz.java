package com.Krishu.DAO;

import com.Krishu.Entity.Quiz;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DAO_Quiz {
    public void saveQuiz(Quiz quiz) {
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        s.persist(quiz);
        transaction.commit();
        s.close();
    }

    public Quiz getQuizById(int id) {
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        Quiz quiz=s.find(Quiz.class,id);
        transaction.commit();
        s.close();
        return quiz;
    }

    public List<Quiz> getAllQuiz() {
        Session s=HibernateUtil.getSession();
        Query<Quiz> query=s.createQuery("FROM Quiz",Quiz.class);
        List<Quiz> ls=query.list();
        s.close();
        return ls;
    }

    public void deleteQuiz(int id) {
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        Quiz quiz=getQuizById(id);
        if(quiz!=null){
            s.remove(quiz);
        }
        transaction.commit();
       s.close();
    }
}
