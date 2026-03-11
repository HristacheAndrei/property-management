package com.example.propertymanagement.controller;

import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.repository.UserRespository;
import com.example.propertymanagement.service.implementations.UserServiceImp;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/createuser")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO responseUserDTO = userServiceImp.register(userDTO);
        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestParam String email, @RequestParam String password) {
        UserDTO responseUserDTO = userServiceImp.login(email, password);
        if (responseUserDTO != null)
            return new ResponseEntity<>(responseUserDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
