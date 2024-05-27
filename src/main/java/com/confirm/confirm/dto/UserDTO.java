package com.confirm.confirm.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String userName;
    private String userSchool;
    private String userCareer;
    private String userPreviousJobCategory;
}