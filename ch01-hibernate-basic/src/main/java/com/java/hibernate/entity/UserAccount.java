package com.java.hibernate.entity;

import com.java.hibernate.model.LoginId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USER_ACCOUNT")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class UserAccount {

    @EmbeddedId
    private LoginId loginId;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "ACCOUNT_TYPE")
    private int accountType;

}
