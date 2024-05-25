package com.confirm.confirm.dto;

import java.util.List;

public class EventRec {
    private String eventName;
    private String location;
    private List<String> eventType;
    private int recruitmentCount;
    private String validDate;
    private String details;

    // Getter and Setter for eventName
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    // Getter and Setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and Setter for eventType
    public List<String> getEventType() {
        return eventType;
    }

    public void setEventType(List<String> eventType) {
        this.eventType = eventType;
    }

    // Getter and Setter for recruitmentCount
    public int getRecruitmentCount() {
        return recruitmentCount;
    }

    public void setRecruitmentCount(int recruitmentCount) {
        this.recruitmentCount = recruitmentCount;
    }

    // Getter and Setter for validDate
    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    // Getter and Setter for details
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
