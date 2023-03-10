package com.example.cv_back.domain;


import com.example.cv_back.infrastructure.exception.DataNotFoundException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.cv_back.infrastructure.error.ErrorMessage.INCORRECT_CREDENTIALS;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;
    public User findUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findUser(username, password);
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }
        User user = optionalUser.get();
        return user;
    }
}
