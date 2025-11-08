package com.java.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "VEHICLE_DATA", schema = "public")
@Getter @Setter @ToString
public class Vehicle {

    public Vehicle() {}

    public Vehicle(String vehicleId, String vehicleName) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
    }

    @Id
    @Column(name = "VEHICLE_ID")
    private String vehicleId;

    @Column(name = "VEHICLE_NAME")
    private String vehicleName;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

}
