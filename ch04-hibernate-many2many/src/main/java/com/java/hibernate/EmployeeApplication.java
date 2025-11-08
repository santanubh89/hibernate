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
        Employee employee1 = new Employee("E1", "Foo Bar");
        Employee employee2 = new Employee("E2", "Adam Joe");
        Vehicle vehicle1 = new Vehicle("V1", "Toyota");
        Vehicle vehicle2 = new Vehicle("V2", "Honda");
        employee1.getVehicles().add(vehicle1);
        employee1.getVehicles().add(vehicle2);
        employee2.getVehicles().add(vehicle1);
        employee2.getVehicles().add(vehicle2);
        // Cascading will handle the other side of the relationship
        /*vehicle1.getEmployees().add(employee1);
        vehicle1.getEmployees().add(employee2);
        vehicle2.getEmployees().add(employee1);
        vehicle2.getEmployees().add(employee2);*/

        Configuration hibernateConfiguration = new Configuration().configure();
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee1);
        session.persist(employee2);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

}