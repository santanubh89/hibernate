package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class NamedNativeQueryDemo {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Employee> query = session.createNamedQuery("EMPLOYEE_DATA.byId", Employee.class);
        query.setParameter("id", 3);
        List<Employee> resultList = query.getResultList();
        System.out.println("ResultList: " +resultList);

        resultList = session.createNamedQuery("EMPLOYEE_DATA.bySkill", Employee.class)
                .setParameter("skill", "Java")
                .getResultList();
        String result = resultList.stream().map(Employee::getEmployeeName).collect(Collectors.joining(", "));
        System.out.println("Java Resources: " +result);


        session.close();
        sessionFactory.close();
    }

}
