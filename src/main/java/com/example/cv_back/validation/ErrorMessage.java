package com.example.cv_back.validation;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    INCORRECT_CREDENTIALS("Wrong username/password", "400"),
    NO_COMPANIES_FOUND("Company entries not found", "404"),
    NO_POSITIONS_FOUND("Position entries not found", "404");


    private final String message;
    private final String code;

    ErrorMessage(String message, String code) {

        this.message = message;
        this.code = code;
    }

}
