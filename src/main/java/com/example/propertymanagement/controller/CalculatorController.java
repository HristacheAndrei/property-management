package com.example.propertymanagement.controller;

import com.example.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//3 WAYS TO EXTRACT DATA FROM AN URL
// 1 -> WITH @REQUESTPARAM(NUMEVARIABILA)
//2 -> WITH @PATHVARIABLE("NUMEVAR") + URL/{NUMEVAR}
//3 -> WITH DTO, WE CAN MAP WHAT WE RECEIVE IN A POST WITH @REQUESTBODY DTOCLASS DTOVAR

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    //with requestParam
    @GetMapping("/add/{num3}")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2 ,@PathVariable("num3") Double num3){
        return  num3+ num1 + num2;
    }
    // with pathVariables
    @GetMapping("/sub/{num1}/{num2}")
    public Double substract(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
        Double result = null;
        if (num1 > num2)
            result = num1 - num2;
        else
            result = num2 - num1;
        return result;
    }

    @PostMapping("/multiply")
    private ResponseEntity<Double> multiply (@RequestBody CalculatorDTO calculatorDTO) {
        Double response =  calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        return new ResponseEntity<Double>(response, HttpStatus.CREATED);
    }
}
