package com.example.cv_back.infrastructure.error;

import lombok.Data;

@Data
public class ApiError {
    private String errorMessage;
    private String errorCode;
}

