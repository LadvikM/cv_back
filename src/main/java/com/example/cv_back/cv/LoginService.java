package com.example.cv_back.cv;

import com.example.cv_back.domain.User;
import com.example.cv_back.domain.UserMapper;
import com.example.cv_back.domain.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = userService.findUser(username, password);
        LoginResponse loginResponse = userMapper.toDto(user);
        return loginResponse;
    }
}
