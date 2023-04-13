package com.example.cv_back.cv.hobbies;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HobbiesController {

    @Resource
    private HobbiesService hobbiesService;

    @GetMapping("/hobbies")
    @Operation(summary = "This service returns hobbies")
    public List<HobbiesDto> getHobbies(Integer userId) {
        List<HobbiesDto> hobbies = hobbiesService.getHobbies(userId);
        return hobbies;
    }

}
