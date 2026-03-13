package com.example.propertymanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BusinessException extends RuntimeException{
    private List<ErrorModel> errorModelList;

    public BusinessException(List<ErrorModel> errorModelList) {
        this.errorModelList = errorModelList;
    }
}
