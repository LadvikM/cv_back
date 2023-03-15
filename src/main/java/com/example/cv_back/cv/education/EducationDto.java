package com.example.cv_back.cv.education;

import lombok.Data;

import java.util.List;

@Data
public class EducationDto {
    private String schoolName;
    private List<SubjectDto> subjects;

    private String countryName;

    private String cityName;
}
