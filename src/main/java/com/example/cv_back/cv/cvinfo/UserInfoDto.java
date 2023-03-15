package com.example.cv_back.cv.cvinfo;


import com.example.cv_back.cv.cvinfo.Dtos.CompaniesDto;
import com.example.cv_back.cv.cvinfo.Dtos.SchoolsDto;
import lombok.Data;

import java.util.List;

@Data
public class UserInfoDto {

    //    private String picture;
    private String description;
    private String github;
    private String linkedin;
    private String telephone;
    private String email;
    private String firstname;
    private String lastname;
    private List<CompaniesDto> companies;
    private List<SchoolsDto> schools;

//    private List<HobbiesDto> hobbies;
}
