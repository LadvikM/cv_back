package com.example.cv_back.cv.cvinfo;

import com.example.cv_back.domain.Entity.User;
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
    public UserInfoDto userInfo(Integer userId) {
        User userInfo = userService.findUserInfo(userId);
        UserInfoDto userInfoDto = userMapper.userInfoDto(userInfo);
        return userInfoDto;
    }
}
