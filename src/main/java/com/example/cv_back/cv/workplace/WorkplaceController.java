package com.example.cv_back.cv.workplace;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkplaceController {
    @Resource
    private WorkplaceService workplaceService;



    @GetMapping("/workplace")
    @Operation(summary = "This service returns user workplace")
    private List<CompanyDto> getWorkplaces(@RequestParam Integer userId) {
        List<CompanyDto> workplaces = workplaceService.getWorkplaces(userId);
        return workplaces;
    }

}
