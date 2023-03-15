package com.example.cv_back.validation;

import com.example.cv_back.domain.entity.Company;
import com.example.cv_back.domain.entity.User;
import com.example.cv_back.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static com.example.cv_back.validation.ErrorMessage.INCORRECT_CREDENTIALS;
import static com.example.cv_back.validation.ErrorMessage.NO_ENTRIES_FOUND;

public class Validator {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }
        User user = optionalUser.get();
        return user;
    }

    public static void checkEntries(List<Company> companies) {
        if (companies.isEmpty()) {
            throw new DataNotFoundException(NO_ENTRIES_FOUND.getMessage(), NO_ENTRIES_FOUND.getCode());
        }
    }
}
