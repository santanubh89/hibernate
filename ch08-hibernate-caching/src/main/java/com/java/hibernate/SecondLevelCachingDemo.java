package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import org.ehcache.CacheManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;


public class SecondLevelCachingDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        sessionFactory.getStatistics().setStatisticsEnabled(true);
        Session session = sessionFactory.openSession();
        System.out.println("----- Query 1 from Session 1 -----");
        Employee e = session.find(Employee.class, 1);
        System.out.println("Employee with ID 1: " + e); // fetched from database

        System.out.println("----- Query 2 from Session 1 -----");
        e = session.find(Employee.class, 1);
        System.out.println("Employee with ID 1: " + e); // fetched from first-level cache

        session.close();

        Session session2 = sessionFactory.openSession();
        System.out.println("----- Query 1 from Session 2 -----");
        e = session2.find(Employee.class, 1);
        System.out.println("Employee with ID 1: " + e); // fetched from database again as session is new

        session2.beginTransaction();
        Employee e1 = Employee.builder().id(100).name("John Doe").build();
        session2.persist(e1);
        session2.getTransaction().commit();
        session2.close();

        sessionFactory.close();

        viewCacheData(sessionFactory);

    }

    private static void viewCacheData(SessionFactory sessionFactory) {
        Statistics stats = sessionFactory.getStatistics();
        for (String regionName : stats.getSecondLevelCacheRegionNames()) {
            System.out.println("Region: " + regionName);
            System.out.println(stats.getCacheRegionStatistics(regionName));
        }
    }
}