package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class NativeQueryDemo {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // SELECT
        String query = "SELECT * FROM EMPLOYEE_DATA WHERE EMP_ID = :id";
        List<Employee> employeeList = session.createNativeQuery(query, Employee.class)
                .setParameter("id", 3)
                .getResultList();
        System.out.println("Employee with ID = 3: " + employeeList.get(0).getEmployeeName());

        // INSERT
        session.beginTransaction();
        query = "INSERT INTO EMPLOYEE_DATA (EMP_ID, EMP_NAME, SKILL, EXPERIENCE, SALARY) VALUES (:id, :name, :skill, :exp, :salary)";
        int rowsInserted = session.createNativeQuery(query, Employee.class)
                .setParameter("id", 1000)
                .setParameter("name", "Alice Johnson")
                .setParameter("skill", "Python")
                .setParameter("exp", 4.0F)
                .setParameter("salary", 75000)
                .executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);

        // UPDATE
        query = "UPDATE EMPLOYEE_DATA SET SALARY = :salary WHERE SKILL = :skill";
        int rowsUpdated = session.createNativeQuery(query, Employee.class)
                .setParameter("salary", 500000)
                .setParameter("skill", "Java")
                .executeUpdate();
        System.out.println("Rows updated: " + rowsUpdated);

        // DELETE
        query = "DELETE FROM EMPLOYEE_DATA WHERE SKILL = :skill";
        int rowsDeleted = session.createNativeQuery(query, Employee.class)
                .setParameter("skill", "Python")
                .executeUpdate();
        System.out.println("Rows deleted: " + rowsDeleted);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

}
