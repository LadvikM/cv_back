package com.example.cv_back.validation;

import com.example.cv_back.domain.user.User;
import com.example.cv_back.infrastructure.exception.DataNotFoundException;

import java.util.Optional;

import static com.example.cv_back.validation.ErrorMessage.INCORRECT_CREDENTIALS;

public class Validator {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }
        User user = optionalUser.get();
        return user;
    }
}
