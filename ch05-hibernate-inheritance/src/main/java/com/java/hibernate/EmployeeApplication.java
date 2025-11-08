package com.java.hibernate;

import com.java.hibernate.entity.joined_table.Developer;
import com.java.hibernate.entity.joined_table.Employee;
import com.java.hibernate.entity.joined_table.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeApplication {

    public static void main(String[] args) {
        Employee employee = new Employee(1, "John Doe");
        Employee developer = new Developer(2, "Foo Bar", "Java, Hibernate");
        Employee manager = new Manager(3, "Jane Smith", 5);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(employee);
        session.persist(developer);
        session.persist(manager);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

}
