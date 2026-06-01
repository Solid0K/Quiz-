package com.Krishu.DAO;

import com.Krishu.Entity.Result;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ResultDAO {
    public void SaveResult(Result result){
        Session s=HibernateUtil.getSession();
        Transaction transaction=s.beginTransaction();
        s.persist(result);
        transaction.commit();
    }

    public List<Result> getResultByUser(int user_id){
        Session s=HibernateUtil.getSession();
        Query<Result> query=s.createQuery("FROM Result where user.id= :id",Result.class);
        query.setParameter("id",user_id);
        List<Result> ls=query.list();
        s.close();
        return ls;
    }
}
