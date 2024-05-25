package com.confirm.confirm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupUser {
    private String businessName;
    private String userId;
    private String userPassword;
    private String businessRegistrationNumber;
}