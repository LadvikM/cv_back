package com.example.cv_back.domain.user;


import com.example.cv_back.domain.entity.User;
import com.example.cv_back.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<User> getActiveCv() {
        List<User> activeCv = userRepository.findActiveCv("A");
        Validator.checkActiveCV(activeCv);
        return activeCv;

    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
