package com.confirm.confirm.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    private String userName;
    private String userPassword;
    private String userSchool;
    private String userCareer;
    private String userPreviousJobCategory;
    @OneToMany(mappedBy = "user")
    private List<UserLog> userLogs;

    public User() {}

    public User(String userName,
                String userId,
                String userPassword,
                String userSchool,
                String userCareer,
                String userPreviousJobCategory) {
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userSchool = userSchool;
        this.userCareer = userCareer;
        this.userPreviousJobCategory = userPreviousJobCategory;
    }

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


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public List<UserLog> getUserLogs() {
        return userLogs;
    }

    public void setUserLogs(List<UserLog> userLogs) {
        this.userLogs = userLogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSchool='" + userSchool + '\'' +
                ", userCareer='" + userCareer + '\'' +
                ", userPreviousJobCategory='" + userPreviousJobCategory + '\'' +
                '}';
    }
}
