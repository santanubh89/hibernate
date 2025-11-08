package com.java.hibernate.entity;

import jakarta.persistence.*;

public class EmployeeEntityEventListener {

    @PrePersist
    public void beforeInsert(Employee employee) {
        System.out.println("EmployeeEntityEventListener::Before persisting: " + employee.getEmpName());
    }

    @PostPersist
    public void afterInsert(Employee employee) {
        System.out.println("EmployeeEntityEventListener::After persisting: " + employee.getEmpName());
    }

    @PreUpdate
    public void beforeUpdate(Employee employee) {
        System.out.println("EmployeeEntityEventListener::Before updating: " + employee.getEmpName());
    }

    @PostUpdate
    public void afterUpdate(Employee employee) {
        System.out.println("EmployeeEntityEventListener::After updating: " + employee.getEmpName());
    }

    @PreRemove
    public void beforeDelete(Employee employee) {
        System.out.println("EmployeeEntityEventListener::Before deleting: " + employee.getEmpName());
    }

    @PostRemove
    public void afterDelete(Employee employee) {
        System.out.println("EmployeeEntityEventListener::After deleting: " + employee.getEmpName());
    }


}
