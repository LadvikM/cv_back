package com.example.cv_back.domain.user;


import com.example.cv_back.domain.Entity.User;
import com.example.cv_back.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Resource
    private UserRepository userRepository;
    public User findUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findUser(username, password);
        User user = Validator.getValidUser(optionalUser);
        return user;
    }


    public User findUserInfo(Integer userId) {
        User user = userRepository.findById(userId).get();
        return user;
    }
}
