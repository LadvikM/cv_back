package com.example.cv_back.cv.workplace;

import com.example.cv_back.cv.education.EducationDto;
import lombok.Data;

import java.util.List;

@Data
public class CvDto {
    private String status;
    private Integer workplaceId;
    private List<WorkplaceDto> workplaces;
    private List<EducationDto> educations;

}
