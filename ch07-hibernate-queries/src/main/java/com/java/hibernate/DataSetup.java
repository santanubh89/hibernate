package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DataSetup {

    public static void main(String[] args) {
        createData();
    }

    private static void createData() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Employee> employeeList = List.of(
                Employee.builder().employeeId(1).employeeName("Foo").skill("Java").experience(10).salary(450000).build(),
                Employee.builder().employeeId(2).employeeName("Bar").skill("Python").experience(3).salary(210000).build(),
                Employee.builder().employeeId(3).employeeName("Baz").skill("Management").experience(7).salary(45000).build(),
                Employee.builder().employeeId(4).employeeName("Adam").skill("Frontend").experience(12).salary(390000).build(),
                Employee.builder().employeeId(5).employeeName("Joe").skill("Data Engineer").experience(6).salary(270000).build(),
                Employee.builder().employeeId(6).employeeName("Karan").skill("AWS").experience(1).salary(230000).build(),
                Employee.builder().employeeId(7).employeeName("Virat").skill("DevOps").experience(4).salary(180000).build(),
                Employee.builder().employeeId(8).employeeName("Rohit").skill("Java").experience(9).salary(420000).build(),
                Employee.builder().employeeId(9).employeeName("Ricky").skill("AWS").experience(17).salary(340000).build(),
                Employee.builder().employeeId(10).employeeName("James").skill("Python").experience(12).salary(150000).build()
        );
        employeeList.forEach(session::persist);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
