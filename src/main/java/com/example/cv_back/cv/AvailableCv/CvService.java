package com.example.cv_back.cv.AvailableCv;

import com.example.cv_back.domain.entity.User;
import com.example.cv_back.domain.user.UserMapper;
import com.example.cv_back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    public List<CvDto> getActiveCv() {
        List<User> activeCv = userService.getActiveCv();
        List<CvDto> cvDtos = userMapper.cvDtos(activeCv);
        return cvDtos;
    }
}
