package com.example.propertymanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice

public class BusinessExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException mavn) {
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        logger.info("Validation errors");
        List<FieldError> fieldErrorList = mavn.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrorList) {
            logger.info("inside field validation: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
            logger.debug("inside field validation: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());

            errorModel = new ErrorModel();
            errorModel.setCode(fieldError.getField());
            errorModel.setMessage(fieldError.getDefaultMessage());
            errorModelList.add(errorModel);
        }
        return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex) {
        bex.getErrorModelList()
                        .forEach(errorModel -> {
                            logger.info("Business exception is thrown - level-info: {} - {}", errorModel.getCode(), errorModel.getMessage());
                            logger.debug("Business exception is thrown - level-debug: {} - {}", errorModel.getCode(), errorModel.getMessage());
                            logger.warn("Business exception is thrown - level-warn: {} - {}", errorModel.getCode(), errorModel.getMessage());
                            logger.error("Business exception is thrown - level-error: {} - {}", errorModel.getCode(), errorModel.getMessage());

                        });
        return new ResponseEntity<>(bex.getErrorModelList(), HttpStatus.BAD_REQUEST);
    }
}
