package com.java.hibernate.entity.table_per_class;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Birds extends Animal {

    public Birds() {}

    public Birds(int animalId, String animalName, int flyingSpeed) {
        super(animalId, animalName);
        this.flyingSpeed = flyingSpeed;
    }

    private int flyingSpeed;

}
