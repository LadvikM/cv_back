package com.example.cv_back.infrastructure.error;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private String errorCode;
}

