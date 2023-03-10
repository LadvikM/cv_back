package com.example.cv_back.cv.sidepanel;

import com.example.cv_back.cv.UserDto;
import com.example.cv_back.domain.user.User;
import com.example.cv_back.domain.user.UserMapper;
import com.example.cv_back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    public UserDto userInfo(Integer userId) {
        User userInfo = userService.findUserInfo(userId);
        UserDto userInfoDto = userMapper.userInfoDto(userInfo);
        return userInfoDto;
    }
}
