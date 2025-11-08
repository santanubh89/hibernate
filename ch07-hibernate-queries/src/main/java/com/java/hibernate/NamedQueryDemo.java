package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class NamedQueryDemo {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Employee> query = session.createNamedQuery("EmployeeEntity.byId", Employee.class);
        query.setParameter("id", 3);
        List<Employee> resultList = query.getResultList();
        System.out.println("ResultList: " +resultList);

        session.close();
        sessionFactory.close();
    }

}
