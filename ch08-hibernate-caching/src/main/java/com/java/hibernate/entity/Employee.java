package com.java.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Table(name = "EMPLOYEE_DATA")
@Cacheable
@Cache(region = "EmployeeEntity", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {

    @Id
    @Column(name = "EMP_ID")
    private int id;

    @Column(name = "EMP_NAME")
    private String name;

}
