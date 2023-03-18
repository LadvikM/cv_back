package com.example.cv_back.cv.users.dtos;

import lombok.Data;

@Data
public class UserInfoDto {
    private String roleId;
    private String username;
    private String password;
    private String picture;
    private String userDescription;
    private String github;
    private String linkedin;
    private String email;
    private String telephone;
    private String firstname;
    private String lastname;
    private String cvStatus;

}
