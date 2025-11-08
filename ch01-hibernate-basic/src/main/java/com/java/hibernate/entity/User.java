package com.java.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USER_DETAILS")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class User {

    @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USER_NAME")
    private String name;

}
