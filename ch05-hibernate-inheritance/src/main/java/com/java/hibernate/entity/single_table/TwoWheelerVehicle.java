package com.java.hibernate.entity.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "TWO_WHEELER")
@DiscriminatorValue("Bike")
public class TwoWheelerVehicle extends Vehicle {

    public TwoWheelerVehicle() {}

    public TwoWheelerVehicle(String vehicleId, String vehicleName, String steeringHandle) {
        super(vehicleId, vehicleName);
        this.steeringHandle = steeringHandle;
    }

    private String steeringHandle;

}
