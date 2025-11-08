package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EntityStateDemo {

    public static void main(String[] args) {

        // Transient State
        Employee employee = new Employee(1, "Foo");

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Persistent State
        session.persist(employee);
        employee.setEmployeeName("Bar");
        session.getTransaction().commit();

        session.close();

        // Detached State
        employee.setEmployeeName("Baz");

    }

}
