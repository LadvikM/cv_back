package com.example.cv_back.cv.education;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EducationController {
    @Resource
    private EducationService educationService;

    @GetMapping("/education")
    @Operation(summary = "This service returns user education")
    private List<SchoolDto> education(@RequestParam Integer userId) {
        List<SchoolDto> schoolDtos = educationService.getEducation(userId);
        return schoolDtos;
    }
}
