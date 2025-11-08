package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.stat.Statistics;

import java.util.List;

public class QueryCacheDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        sessionFactory.getStatistics().setStatisticsEnabled(true);
        Session session1 = sessionFactory.openSession();

        Query<Employee> query = null;
        List<Employee> empList = null;

        System.out.println("------Session 1 Query 1------");
        query = session1.createQuery("from Employee emp where emp.id = 1", Employee.class);
        query.setCacheable(true);
        empList = query.list();

        System.out.println("------Session 1 Query 2------");
        query = session1.createQuery("from Employee emp where emp.id = 1", Employee.class);
        query.setCacheable(true);
        empList = query.list();
        session1.close();

        Session session2 = sessionFactory.openSession();

        System.out.println("------Session 2 Query 1------");
        query = session2.createQuery("from Employee emp where emp.id = 1", Employee.class);
        query.setCacheable(true);
        empList = query.list();

        session2.close();
        sessionFactory.close();

        cacheData(sessionFactory);

    }

    private static void cacheData(SessionFactory sessionFactory) {
        Statistics stats = sessionFactory.getStatistics();
        for (String regionName : stats.getSecondLevelCacheRegionNames()) {
            System.out.println("Region: " + regionName);
            System.out.println(stats.getCacheRegionStatistics(regionName));
        }
    }

}
