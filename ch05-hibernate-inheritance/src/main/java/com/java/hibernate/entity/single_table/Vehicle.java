package com.java.hibernate.entity.single_table;

import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@Entity(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("vehicle")
public class Vehicle {

    @Id
    private String vehicleId;

    private String vehicleName;

}
