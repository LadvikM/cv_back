package com.example.cv_back.infrastructure.error;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    INCORRECT_CREDENTIALS("Wrong username/password", "400");

    private final String message;
    private final String code;

    ErrorMessage(String message, String code) {

        this.message = message;
        this.code = code;
    }

}
