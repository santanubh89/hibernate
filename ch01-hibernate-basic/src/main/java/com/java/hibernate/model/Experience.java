package com.java.hibernate.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class Experience {

    private String organization;

    private float duration;

}
