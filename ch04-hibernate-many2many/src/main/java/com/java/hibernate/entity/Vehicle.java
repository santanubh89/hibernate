package com.java.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "vehicles")
    private List<Employee> employees = new ArrayList<>();

}
