package com.example.cv_back.cv.AvailableCv;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CvController {
    @Resource
    private CvService cvService;

    @GetMapping("/activecv")
    @Operation(summary = "This service returns users with active CVs")
    public List<CvDto> getActiveCv() {
        List<CvDto> activeCv = cvService.getActiveCv();
        return activeCv;
    }
}
