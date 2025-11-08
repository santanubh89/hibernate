package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import com.java.hibernate.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeApplication {
    public static void main(String[] args) {
        create();

        // getEmployee();

        // getVehicle();

        // delete();
    }

    private static void create() {
        Employee employee = new Employee("E1", "Foo Bar");
        Vehicle vehicle1 = new Vehicle("V1", "Toyota");
        Vehicle vehicle2 = new Vehicle("V2", "Honda");
        employee.getVehicle().add(vehicle1);
        employee.getVehicle().add(vehicle2);
        vehicle1.setEmployee(employee);
        vehicle2.setEmployee(employee);

        Configuration hibernateConfiguration = new Configuration().configure();
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        // session.persist(vehicle1);
        // session.persist(vehicle2);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    private static void getEmployee() {
        Configuration hibernateConfiguration = new Configuration().configure();
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee = session.find(Employee.class, "E1");
        System.out.println("Employee Name: " + employee.getEmployeeName());
        for (Vehicle vehicle : employee.getVehicle()) {
            System.out.println("Vehicle Name: " + vehicle.getVehicleName());
        }

        session.close();
        sessionFactory.close();
    }

    private static void getVehicle() {
        Configuration hibernateConfiguration = new Configuration().configure();
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Vehicle vehicle = session.find(Vehicle.class, "V1");
        System.out.println("Vehicle Name: " + vehicle);
        System.out.println("Employee Name: " + vehicle.getEmployee().getEmployeeName());

        session.close();
        sessionFactory.close();
    }

    private static void delete() {
        Configuration hibernateConfiguration = new Configuration().configure();
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee employee = session.find(Employee.class, "E1");
        session.remove(employee);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

}