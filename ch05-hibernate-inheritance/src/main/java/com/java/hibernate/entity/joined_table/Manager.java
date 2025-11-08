package com.java.hibernate.entity.joined_table;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "MANAGER")
public class Manager extends Employee {

    private int numberOfTeams;

    public Manager() {}

    public Manager(int employeeId, String employeeName, int numberOfTeams) {
        super(employeeId, employeeName);
        this.numberOfTeams = numberOfTeams;
    }
}
