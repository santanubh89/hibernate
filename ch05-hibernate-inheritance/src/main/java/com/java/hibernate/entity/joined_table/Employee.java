package com.java.hibernate.entity.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "EMPLOYEE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

    @Id
    private int employeeId;

    private String employeeName;

}
