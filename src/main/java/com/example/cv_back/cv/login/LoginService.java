package com.example.cv_back.cv.login;

import com.example.cv_back.domain.user.User;
import com.example.cv_back.domain.user.UserMapper;
import com.example.cv_back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    public UserDto login(String username, String password) {
        User user = userService.findUser(username, password);
        UserDto loginResponse = userMapper.toDto(user);
        return loginResponse;
    }
}
