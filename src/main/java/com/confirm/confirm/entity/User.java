package com.confirm.confirm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private String userPassword;
    private String userSchool;
    private String userCareer;
    private String userPreviousJobCategory;

    @OneToMany(mappedBy = "user")
    private List<UserLog> userLogs;

    // Custom constructor without userId
    public User(String userName,
                String userPassword,
                String userSchool,
                String userCareer,
                String userPreviousJobCategory) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSchool = userSchool;
        this.userCareer = userCareer;
        this.userPreviousJobCategory = userPreviousJobCategory;
    }
}
