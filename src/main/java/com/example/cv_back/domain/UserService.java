package com.example.cv_back.domain;


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
}
