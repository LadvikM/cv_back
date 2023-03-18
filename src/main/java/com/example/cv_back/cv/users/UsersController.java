package com.example.cv_back.cv.users;

import com.example.cv_back.cv.users.dtos.UserInfoDto;
import com.example.cv_back.cv.users.dtos.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
    @Resource
    UsersService usersService;

    @PostMapping("/register")
    @Operation(summary = "This service adds new user to 'User' table")
    public void addNewUser(@RequestBody UserInfoDto newUserDto) {
        usersService.addNewUser(newUserDto);
    }


    @GetMapping("/login")
    @Operation(summary = "This service allows user to log in")
    public UserDto login(@RequestParam String username, @RequestParam String password) {
        UserDto login = usersService.login(username, password);
        return login;
    }
    @PutMapping("/user/edit")
    @Operation(summary = "This service allows user to edit user info")
    public void editUser(@RequestParam Integer userId, @RequestBody UserInfoDto userInfoDto) {
        usersService.editUser(userId, userInfoDto);
    }
    @DeleteMapping("/user/delete")
    @Operation(summary = "Deletes user", description = "Only works when there are no references in other tables")
    public void deleteUser(@RequestParam Integer userId) {
        usersService.deleteUser(userId);
    }
}
