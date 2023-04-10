package com.example.cv_back.cv.additional_info;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AdditionalInfoController {

    @Resource
    private AdditionalInfoService additionalInfoService;

    @GetMapping("/additionalinfo")
    @Operation(summary = "This service returns user's additional information")
    public List<AdditionalInfoDto> getAdditionalInfo(Integer userId) {
        List<AdditionalInfoDto> additionalInfo = additionalInfoService.getAdditionalInfo(userId);
        return additionalInfo;
    }
}
