package com.confirm.confirm.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobRec {
    private String subject;
    private List<String> companySize;
    private List<String> experience;
    private List<String> jobCategory;
    private String expiryDate;
    private int salary;
    private int recruitmentCount;
    private String details;
}
