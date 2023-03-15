package com.example.cv_back.cv.cvinfo;

import lombok.Data;

import java.util.List;

@Data
public class SchoolsDto {
    private String schoolName;

    private String cityName;
    private String countryName;

    private List<SubjectsDto> subjects;

}
