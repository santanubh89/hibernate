package com.java.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Table(name = "LOG_EVENT")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class LogEvent {

    @Id
    @Column(name = "LOG_ID")
    @GenericGenerator(name = "log-id-gen", strategy = "com.java.hibernate.util.LogIdGenerator")
    @GeneratedValue(generator = "log-id-gen")
    private String logId;

    @Column(name = "EVENT_TYPE")
    private String eventType;

    @Column(name = "EVENT_DESC")
    private String eventDescription;

}
