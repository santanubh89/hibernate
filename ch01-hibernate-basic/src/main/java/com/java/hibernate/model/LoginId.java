package com.java.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class LoginId {

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL_ID")
    private String emailId;

}
