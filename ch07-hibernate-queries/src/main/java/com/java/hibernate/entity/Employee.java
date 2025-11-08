package com.java.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@ToString
@Entity(name = "EmployeeEntity")
@NamedQueries({
        @NamedQuery(name = "EmployeeEntity.byId", query = "from EmployeeEntity where employeeId = :id", resultClass = Employee.class),
        @NamedQuery(name = "EmployeeEntity.salaryMoreThan", query = "from EmployeeEntity where salary > :salary"),
        @NamedQuery(name = "EmployeeEntity.bySkill", query = "from EmployeeEntity where skill = :skill")
})

@NamedNativeQueries({
        @NamedNativeQuery(name = "EMPLOYEE_DATA.byId", query = "SELECT * FROM EMPLOYEE_DATA where EMP_ID = :id", resultClass = Employee.class),
        @NamedNativeQuery(name = "EMPLOYEE_DATA.salaryMoreThan", query = "SELECT * FROM EMPLOYEE_DATA where SALARY > :salary", resultClass = Employee.class),
        @NamedNativeQuery(name = "EMPLOYEE_DATA.bySkill", query = "SELECT * FROM EMPLOYEE_DATA where SKILL = :skill", resultClass = Employee.class)
})
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    @Id
    @Column(name = "EMP_ID")
    private int employeeId;

    @Column(name = "EMP_NAME")
    private String employeeName;

    @Column(name = "SKILL")
    private String skill;

    @Column(name = "EXPERIENCE")
    private float experience;

    @Column(name = "SALARY")
    private int salary;

}
