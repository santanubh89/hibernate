package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import com.java.hibernate.entity.HibernateEventInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {
    public static void main(String[] args) {
        Configuration configure = new Configuration().configure();
        configure.setInterceptor(new HibernateEventInterceptor());
        SessionFactory sessionFactory = configure.buildSessionFactory();

        purge(sessionFactory);

        insert(sessionFactory);

        query(sessionFactory);

        update(sessionFactory);

        delete(sessionFactory);

        sessionFactory.close();
    }

    private static void purge(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Employee").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    private static void insert(SessionFactory sessionFactory) {
        Employee e = new Employee(1, "Foo", 100000F, "Engineering");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(e);
        session.getTransaction().commit();
        session.close();
    }

    private static void query(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Employee employee = session.find(Employee.class, 1);
        session.close();
    }

    private static void update(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.find(Employee.class, 1);
        employee.setEmpName("Foo Bar");
        session.getTransaction().commit();
        session.close();
    }

    private static void delete(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.find(Employee.class, 1);
        session.remove(employee);
        session.getTransaction().commit();
        session.close();
    }
}