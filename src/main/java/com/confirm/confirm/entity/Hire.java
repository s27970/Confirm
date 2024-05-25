package com.confirm.confirm.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jotTitle;

    private String companySize;

    private String experience;

    private String major;

    private String education;

    private String jobCategory;

    @Temporal(TemporalType.DATE)
    private Date expireDate;

    private String salary;

    private Integer recruitmentCount;

    @Lob
    private String detail;

    private String imagePath;

    private String companyName;

    private String industry;

    private String welfare;

    private String workTime;

    private String position1;

    private String position2;

}
