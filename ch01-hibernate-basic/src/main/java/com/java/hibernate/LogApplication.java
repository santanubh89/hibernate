package com.java.hibernate;

import com.java.hibernate.entity.LogEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LogApplication {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            LogEvent logEvent = LogEvent.builder()
                    .eventType("CREATE").eventDescription("User Created Successfully")
                    .build();
            session.beginTransaction();
            session.persist(logEvent);
            session.getTransaction().commit();
        }


    }

}
