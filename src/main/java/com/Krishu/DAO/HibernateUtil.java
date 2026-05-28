package com.Krishu.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory factory;

    static{
        Configuration config=new Configuration();
        config.configure();
        factory=config.buildSessionFactory();
    }

    public static Session getSession(){
        return factory.openSession();
    }

    public static void shutdown() {
        factory.close();
    }
}
