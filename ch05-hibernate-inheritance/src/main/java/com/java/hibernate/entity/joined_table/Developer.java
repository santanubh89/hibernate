package com.java.hibernate.entity.joined_table;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "DEVELOPER")
public class Developer extends Employee {

    private String skillSet;

    public Developer() {}

    public Developer(int employeeId, String employeeName, String skillSet) {
        super(employeeId, employeeName);
        this.skillSet = skillSet;
    }

}
