package com.java.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA", schema = "public")
@Getter
@Setter
public class Employee {

    public Employee() {}

    public Employee(String employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @OneToMany(cascade = {CascadeType.ALL},fetch =  FetchType.EAGER/*, mappedBy = "employee"*/)
    @JoinTable(name = "EMPLOYEE_VEHICLE",
            joinColumns = @JoinColumn(name = "EID"),
            inverseJoinColumns = @JoinColumn(name = "VID"))
    private List<Vehicle> vehicle = new ArrayList<>();
}
