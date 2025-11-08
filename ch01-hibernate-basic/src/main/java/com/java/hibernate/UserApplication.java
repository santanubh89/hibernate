package com.java.hibernate;

import com.java.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserApplication {

    public static void main(String[] args) {
        User user = new User();
        user.setName("Karan");
        Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        }

    }

}
