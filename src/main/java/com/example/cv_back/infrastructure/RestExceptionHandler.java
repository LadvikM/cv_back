package com.example.cv_back.infrastructure;

import com.example.cv_back.infrastructure.error.ApiError;
import com.example.cv_back.infrastructure.exception.BusinessException;
import com.example.cv_back.infrastructure.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiError> handleDataNotFoundException(DataNotFoundException exception) {
        ApiError apiError = new ApiError();
        apiError.setErrorMessage(exception.getMessage());
        apiError.setErrorCode(exception.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }



}
