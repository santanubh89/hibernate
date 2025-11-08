package com.java.hibernate.entity.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "FOUR_WHEELER")
@DiscriminatorValue("Car")
public class FourWheelerVehicle extends Vehicle {

    public FourWheelerVehicle() {}

    public FourWheelerVehicle(String vehicleId, String vehicleName, String steeringHandle) {
        super(vehicleId, vehicleName);
        this.steeringWheel = steeringHandle;
    }

    private String steeringWheel;

}
