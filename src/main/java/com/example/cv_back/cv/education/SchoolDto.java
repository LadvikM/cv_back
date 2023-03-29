package com.example.cv_back.cv.education;

import com.example.cv_back.domain.entity.Subject;
import lombok.Data;

import java.util.List;

@Data
public class SchoolDto {
 private Integer schoolId;
 private String schoolName;
 private String cityName;
 private String countryName;

 private List<SubjectsDto> subjects;
}
