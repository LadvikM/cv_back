package com.example.cv_back.cv.workplace;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkplaceController {
    @Resource
    private WorkplaceService workplaceService;

    @GetMapping("/workplaces")
    @Operation(summary = "This service returns user workplaces")
    private List<CompanyDto> getWorkplaces(@RequestParam Integer userId) {
        List<CompanyDto> workplaces = workplaceService.getWorkplaces(userId);
        return workplaces;
    }
}
