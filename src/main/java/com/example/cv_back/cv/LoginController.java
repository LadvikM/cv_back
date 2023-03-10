package com.example.cv_back.cv;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Resource LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "This service allows user to log in")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        LoginResponse login = loginService.login(username, password);
        return login;
    }
}
