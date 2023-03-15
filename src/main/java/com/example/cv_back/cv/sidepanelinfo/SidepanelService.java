package com.example.cv_back.cv.sidepanelinfo;

import com.example.cv_back.domain.entity.User;
import com.example.cv_back.domain.user.UserMapper;
import com.example.cv_back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SidepanelService {

    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    public SidepanelDto userInfo(Integer userId) {
        User userInfo = userService.findUserInfo(userId);
        SidepanelDto userInfoDto = userMapper.userInfoDto(userInfo);

        return userInfoDto;
    }
}
