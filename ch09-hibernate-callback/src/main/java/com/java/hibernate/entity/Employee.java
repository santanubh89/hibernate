package com.java.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
@Entity
// @EntityListeners({EmployeeEntityEventListener.class})
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    @Id
    @Column(name = "EMP_ID")
    private int empId;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "SALARY")
    private float salary;

    @Column(name = "DEPARTMENT")
    private String department;

}
