package com.confirm.confirm.entity;

import jakarta.persistence.*;
import lombok.Getter;


import java.util.Date;

@Getter
@Entity
public class EventJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int recruitmentCount;

    @Temporal(TemporalType.DATE)
    private Date validDate;

    @Column(length = 1000)
    private String details;

    private String eventType;

    private String imagePath;

    private String fairName;

    private String organizerName;

    private String keyword;

    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTime;

    // Getters and Setters
}
