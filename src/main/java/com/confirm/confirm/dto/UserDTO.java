package com.confirm.confirm.dto;

public class UserDTO {
    private String userId;
    private String userName;
    private String userSchool;
    private String userCareer;
    private String userPreviousJobCategory;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getUserCareer() {
        return userCareer;
    }

    public void setUserCareer(String userCareer) {
        this.userCareer = userCareer;
    }

    public String getUserPreviousJobCategory() {
        return userPreviousJobCategory;
    }

    public void setUserPreviousJobCategory(String userPreviousJobCategory) {
        this.userPreviousJobCategory = userPreviousJobCategory;
    }
}
