package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import com.java.hibernate.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeApplication {
    public static void main(String[] args) {

        create();


    }

    private static void create() {
        Employee employee = new Employee("E1", "Foo Bar");
        Vehicle vehicle = new Vehicle("V1", "Toyota");
        employee.setVehicle(vehicle);

        Configuration hibernateConfiguration = new Configuration().configure();
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        session.persist(vehicle);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

}