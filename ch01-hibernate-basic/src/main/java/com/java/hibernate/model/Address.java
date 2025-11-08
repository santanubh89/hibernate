package com.java.hibernate.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class Address {

    private String city;

    private String state;

    private String country;

}
