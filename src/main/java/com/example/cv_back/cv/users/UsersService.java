package com.example.cv_back.cv.users;

import com.example.cv_back.cv.users.dtos.UserInfoDto;
import com.example.cv_back.cv.users.dtos.UserDto;
import com.example.cv_back.domain.entity.User;
import com.example.cv_back.domain.user.UserMapper;
import com.example.cv_back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    public UserDto login(String username, String password) {
        User user = userService.findUser(username, password);
        UserDto loginResponse = userMapper.toDto(user);
        return loginResponse;
    }

    public void addNewUser(UserInfoDto newUserDto) {
        User user = userMapper.toEntity(newUserDto);
        userService.saveUser(user);
    }

    public void editUser(Integer userId, UserInfoDto userInfoDto) {
        User userInfo = userService.findUserInfo(userId);
        User user = userMapper.editUser(userInfo, userInfoDto);
        userService.saveUser(user);
    }

    public void deleteUser(Integer userId) {
        userService.deleteUser(userId);
    }
}
