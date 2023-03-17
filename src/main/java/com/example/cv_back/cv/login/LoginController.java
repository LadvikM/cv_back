package com.example.cv_back.cv.login;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Resource
    LoginService loginService;

    @PostMapping("/register")
    @Operation(summary = "This service adds new user to 'User' table")
    public void addNewUser(@RequestBody NewUserDto newUserDto) {
        loginService.addNewUser(newUserDto);
    }



    @GetMapping("/login")
    @Operation(summary = "This service allows user to log in")
    public UserDto login(@RequestParam String username, @RequestParam String password) {
        UserDto login = loginService.login(username, password);
        return login;
    }
}
