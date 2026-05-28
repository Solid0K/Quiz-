package com.Krishu.DAO;

import com.Krishu.Entity.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionDAO {
    public void saveQuestion(Question question){
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        s.persist(question);
        transaction.commit();
        s.close();
    }

    public Question getQuestionById(int id){
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        Question getted_question=s.find(Question.class,id);
        transaction.commit();
        s.close();
        return getted_question;
    }

    public List<Question> getQuestionsByQuiz(int Quiz_id){
        Session s=HibernateUtil.getSession();
        Query<Question> query=s.createQuery("FROM Question where quiz.id= :id",Question.class);
        query.setParameter("id",Quiz_id);
        List<Question> questions=query.list();
        s.close();
        return questions;
    }
}
