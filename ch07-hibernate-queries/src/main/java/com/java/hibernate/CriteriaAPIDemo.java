package com.java.hibernate;

import com.java.hibernate.entity.Employee;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CriteriaAPIDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        orderByAllRows(session);
    }

    private static void singleComparison(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        Predicate salaryPredicate = cb.greaterThan(root.get("salary"), 400000);
        cq.select(root).where(salaryPredicate);
        List<Employee> employeeList = session.createQuery(cq).list();
        System.out.println(employeeList);
    }

    private static void between(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        Predicate idBetweenPredicate = cb.between(root.get("employeeId"), 1, 4);
        cq.select(root).where(idBetweenPredicate);
        List<Employee> employeeList = session.createQuery(cq).list();
        System.out.println(employeeList);
    }

    private static void like(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        Predicate likePredicate = cb.like(root.get("employeeName"), "Ba%");
        cq.select(root).where(likePredicate);
        List<Employee> employeeList = session.createQuery(cq).list();
        System.out.println(employeeList);
    }

    private static void in(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        Predicate inPredicate = root.get("employeeName").in("Foo", "Bar", "Baz");
        cq.select(root).where(inPredicate);
        List<Employee> employeeList = session.createQuery(cq).list();
        System.out.println(employeeList);
    }

    private static void andCondition(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        Predicate salaryPredicate = cb.greaterThan(root.get("salary"), 300000);
        Predicate experiencePredicate = cb.lessThan(root.get("experience"), 5);
        cq.select(root).where(salaryPredicate, experiencePredicate); // AND condition
        List<Employee> employeeList = session.createQuery(cq).list();
        System.out.println(employeeList);
    }

    private static void orConditionSpecificColumns(Session session) {
        record EmployeeSalary(String employeeName, double salary) {}

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<EmployeeSalary> cq = cb.createQuery(EmployeeSalary.class);
        Root<Employee> root = cq.from(Employee.class);
        Predicate salaryPredicate = cb.equal(root.get("skill"), "Java");
        Predicate experiencePredicate = cb.greaterThan(root.get("experience"), 8);
        Predicate finalPredicate = cb.or(salaryPredicate, experiencePredicate); // OR condition

        cq.select(cb.construct(EmployeeSalary.class, // Specific columns
                root.get("employeeName"),
                root.get("salary")
        )).where(finalPredicate);
        List<EmployeeSalary> employeeList = session.createQuery(cq).list();
        System.out.println(employeeList);
    }

    private static void count(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(cb.count(root));
        Long count = session.createQuery(cq).getSingleResult();
        System.out.println("Count of Employees = "+count);
    }

    private static void aggregateFunctions(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Number> cq = cb.createQuery(Number.class);
        Root<Employee> root = cq.from(Employee.class);

        cq.select(cb.max(root.get("salary")));
        Number maxSalary = session.createQuery(cq).getSingleResult();
        System.out.println("Max Salary = "+maxSalary);

        cq.select(cb.min(root.get("salary")));
        Number minSalary = session.createQuery(cq).getSingleResult();
        System.out.println("Min Salary = "+minSalary);

        cq.select(cb.sum(root.get("salary")));
        Number totalSalary = session.createQuery(cq).getSingleResult();
        System.out.println("Total Salary = "+totalSalary);

        cq.select(cb.avg(root.get("salary")));
        Number avgSalary = session.createQuery(cq).getSingleResult();
        System.out.println("Average Salary = "+avgSalary);
    }

    private static void orderByAllRows(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        cq.orderBy(cb.desc(root.get("salary")));
        List<Employee> employeeList = session.createQuery(cq).list();
        System.out.println(employeeList);
    }

    // groupby orderby

}
