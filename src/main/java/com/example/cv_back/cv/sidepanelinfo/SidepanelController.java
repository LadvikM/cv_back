package com.example.cv_back.cv.sidepanelinfo;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SidepanelController {
    @Resource
    private SidepanelService userInfoService;

    @GetMapping("/userinfo")
    @Operation(summary = "This service returns user info for sidepanel")
    public SidepanelDto userInfo(@RequestParam Integer userId) {
        SidepanelDto userDto = userInfoService.userInfo(userId);
        return userDto;
    }

}
