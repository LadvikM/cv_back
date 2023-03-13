package com.example.cv_back.cv.sidepanel;

import com.example.cv_back.cv.login.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/userinfo")
    @Operation(summary = "This service returns user info for sidepanels")
    public UserInfoDto userInfo(@RequestParam Integer userId) {
        UserInfoDto userDto = userInfoService.userInfo(userId);
        return userDto;
    }


}
