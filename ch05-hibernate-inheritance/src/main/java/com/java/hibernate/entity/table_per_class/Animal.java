package com.java.hibernate.entity.table_per_class;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal {

    @Id
    private int animalId;

    private String animalName;

}
