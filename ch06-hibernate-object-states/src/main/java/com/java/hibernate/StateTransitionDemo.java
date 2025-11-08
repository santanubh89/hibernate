package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.concurrent.TimeUnit;

public class StateTransitionDemo {

    public static void main(String[] args) throws InterruptedException {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Persistent State
        Employee employee = session.find(Employee.class, 1);
        session.getTransaction().commit();
        session.close();

        TimeUnit.SECONDS.sleep(1);

        employee.setEmployeeName("Baz");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(employee); // Merging Detached State to Persistent State
        session.getTransaction().commit();
        session.close();

    }

}
