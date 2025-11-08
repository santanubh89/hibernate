package com.java.hibernate;

import com.java.hibernate.model.Address;
import com.java.hibernate.entity.Employee;
import com.java.hibernate.model.Experience;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

import static com.java.hibernate.util.Utils.*;

public class EmployeeApplication {
    public static void main(String[] args) {

        // persist();

        // get();

        findLazy();

        // update();

        // delete();

    }

    private static void persist() {
        Employee employee = Employee.builder()
                .employeeId(1).employeeName("Foo Bar")
                .joiningDate(LocalDate.now())
                .address(
                        Address.builder().city("Mumbai").state("MH").country("India").build()
                )
                .bioData(bioData()).password("secret")
                .experiences(List.of(
                        Experience.builder().organization("Meta").duration(3.1F).build(),
                        Experience.builder().organization("Google").duration(5.4F).build()
                ))
                .isActive(true).build();

        Configuration hibernateConfiguration = new Configuration().configure();
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
        System.out.println(sessionFactory);
    }

    private static void find() {
        Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Employee employee = session.find(Employee.class, 1);
            System.out.println("Employee Object:\n" + employee);
        }
    }

    private static void findLazy() {
        Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Employee employee = session.find(Employee.class, 1);
            session.close();
            System.out.println("Employee Object:\n" + employee);
        }
    }

    private static void update() {
        Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Employee employee = session.find(Employee.class, 1);
            employee.setEmployeeName("Baz Baz");
            employee.setActive(false);
            session.merge(employee);
            session.getTransaction().commit();
        }
    }

    private static void delete() {
        Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Employee employee = session.find(Employee.class, 1);
            session.remove(employee);
            session.getTransaction().commit();
        }
    }
}