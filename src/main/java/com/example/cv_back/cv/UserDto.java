package com.example.cv_back.cv;

import lombok.Data;

@Data
public class UserDto {
    private String userId;
    private String roleType;
//    private String picture;
    private String description;
    private String github;
    private String linkedin;
    private String telephone;
    private String email;
    private String firstname;
    private String lastname;

}
