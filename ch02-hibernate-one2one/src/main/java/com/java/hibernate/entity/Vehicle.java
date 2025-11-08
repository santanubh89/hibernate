package com.java.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "VEHICLE_DATA", schema = "public")
@Getter @Setter
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

}
