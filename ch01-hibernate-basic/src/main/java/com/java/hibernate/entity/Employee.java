package com.java.hibernate.entity;

import com.java.hibernate.model.Address;
import com.java.hibernate.model.Experience;
import com.java.hibernate.util.BooleanYNConverter;
import com.java.hibernate.util.Utils;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "EMPLOYEE_ENTITY")
@Table(name = "EMPLOYEE_DATA", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "DATE_OF_JOINING")
    // @Temporal(TemporalType.DATE)
    private LocalDate joiningDate;

    @Column(name = "Address")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "EMP_CITY")),
            @AttributeOverride(name = "state", column = @Column(name = "EMP_STATE")),
            @AttributeOverride(name = "country", column = @Column(name = "EMP_COUNTRY"))
    })
    private Address address;

    @Column(name = "BIO_DATA", columnDefinition = "TEXT")
    @Lob
    private String bioData;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "EMPLOYEE_EXPERIENCE", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), foreignKey = @ForeignKey(name = "EMP_EXPERIENCE_FK"))
    // @CollectionId(column = @Column(name = "EMP_EXPERIENCE_ID"), generator = "experience_gen", type = @Type("long"))
    // @JoinTable(name = "EMPLOYEE_EXPERIENCE_JT", joinColumns = @JoinColumn(name = "EMPLOYEE_ID_JT"))
    private List<Experience> experiences;

    @Column(name = "IS_ACTIVE")
    @Convert(converter = BooleanYNConverter.class)
    private boolean isActive;

    @Transient
    private String password;

    @Override
    public String toString() {
        return Utils.toJson(this);
    }
}
