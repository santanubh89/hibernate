package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCachingDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Employee e1 = session.find(Employee.class, 1);
        System.out.println("Employee with ID 1: " + e1); // fetched from database

        e1 = session.find(Employee.class, 1);
        System.out.println("Employee with ID 1: " + e1); // fetched from first-level cache

        session.close();

        session = sessionFactory.openSession();
        e1 = session.find(Employee.class, 1);
        System.out.println("Employee with ID 1: " + e1); // fetched from database again as session is new

        e1.setName("Foo Foo"); // modifying the entity

        e1 = session.find(Employee.class, 1);
        System.out.println("Employee with ID 1: " + e1); // fetched from first-level cache with updated name

        sessionFactory.close();

    }
}