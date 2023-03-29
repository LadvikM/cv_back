package com.example.cv_back.validation;

import com.example.cv_back.domain.entity.*;
import com.example.cv_back.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static com.example.cv_back.validation.ErrorMessage.*;
import static org.apache.logging.log4j.ThreadContext.isEmpty;

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
            throw new DataNotFoundException(NO_COMPANIES_FOUND.getMessage(), NO_COMPANIES_FOUND.getCode());
        }
    }

    public static void checkPositionEntries(List<Position> positions) {
        if (positions.isEmpty()) {
            throw new DataNotFoundException(NO_POSITIONS_FOUND.getMessage(), NO_POSITIONS_FOUND.getCode());
        }
    }
    public static void checkSchoolEntries(List<School> schools) {
        if (schools.isEmpty()) {
            throw new DataNotFoundException(NO_SCHOOLS_FOUND.getMessage(), NO_POSITIONS_FOUND.getCode());
        }
    }
    public static void checkSubjectsEntries(List<Subject> subjects) {
        if (subjects.isEmpty()) {
            throw new DataNotFoundException(NO_SUBJECTS_FOUND.getMessage(), NO_POSITIONS_FOUND.getCode());
        }
    }

    public static void checkActiveCV(List<User> activeCv) {
        if (activeCv.isEmpty()) {
            throw new DataNotFoundException(NO_ACTIVE_CVS.getMessage(), NO_ACTIVE_CVS.getCode());
        }
    }
}
