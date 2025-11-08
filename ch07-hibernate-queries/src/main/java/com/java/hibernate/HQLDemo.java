package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HQLDemo {
    public static void main(String[] args) {
        hqlDemo();
    }

    private static void hqlDemo() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Select all
        Query<Employee> query = session.createQuery("from EmployeeEntity", Employee.class);
        List<Employee> employeeList = query.list();
        System.out.println("Size of employee list: " + employeeList.size());

        // Select where
        query = session.createQuery("from EmployeeEntity where employeeId > 5", Employee.class);
        employeeList = query.list();
        System.out.println("Size of filtered employee list: " + employeeList.size());

        // Pagination
        query = session.createQuery("from EmployeeEntity", Employee.class);
        query.setFirstResult(6);
        query.setMaxResults(3);
        employeeList = query.list();
        String result = employeeList.stream().map(Employee::getEmployeeName).collect(Collectors.joining(", "));
        System.out.println("Paginated employee names: " + result);

        // Select specific columns
        Query<String> employeeNameQuery = session.createQuery("select employeeName from EmployeeEntity where employeeId > 5", String.class);
        List<String> nameList = employeeNameQuery.list();
        System.out.println("Employee names: " + nameList);

        // Aggregate function
        Query<Long> countQuery = session.createQuery("select count(employeeId) from EmployeeEntity", Long.class);
        Long count = countQuery.uniqueResult();
        System.out.println("Total number of employees: " + count);

        // Parameter binding - ?
        query = session.createQuery("from EmployeeEntity where employeeId = ?1 or employeeId = ?2", Employee.class);
        query.setParameter(1, 5);
        query.setParameter(2, 6);
        employeeList = query.list();
        result = employeeList.stream().map(Employee::getEmployeeName).collect(Collectors.joining(", "));
        System.out.println("Employee names (Or Query): " + result);

        // Parameter binding - :
        query = session.createQuery("from EmployeeEntity where employeeId = :id", Employee.class);
        query.setParameter("id", 5);
        employeeList = query.list();
        result = employeeList.get(0).getEmployeeName();
        System.out.println("Employee with ID 5: " + result);

        session.close();
        sessionFactory.close();
    }

}