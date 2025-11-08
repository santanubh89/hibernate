package com.java.hibernate.entity.table_per_class;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mammals extends Animal {

    public Mammals() {}

    public Mammals(int animalId, String animalName, int runningSpeed) {
        super(animalId, animalName);
        this.runningSpeed = runningSpeed;

    }

    private int runningSpeed;

}
