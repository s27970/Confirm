package com.confirm.confirm.dto;

import java.util.List;

public class JobRec {
    private String subject;
    private List<String> companySize;
    private List<String> experience;
    private List<String> jobCategory;
    private String expiryDate;
    private int salary;
    private int recruitmentCount;
    private String details;

    // Getter and Setter for subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Getter and Setter for companySize
    public List<String> getCompanySize() {
        return companySize;
    }

    public void setCompanySize(List<String> companySize) {
        this.companySize = companySize;
    }

    // Getter and Setter for experience
    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    // Getter and Setter for jobCategory
    public List<String> getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(List<String> jobCategory) {
        this.jobCategory = jobCategory;
    }

    // Getter and Setter for expiryDate
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Getter and Setter for salary
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Getter and Setter for recruitmentCount
    public int getRecruitmentCount() {
        return recruitmentCount;
    }

    public void setRecruitmentCount(int recruitmentCount) {
        this.recruitmentCount = recruitmentCount;
    }

    // Getter and Setter for details
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
