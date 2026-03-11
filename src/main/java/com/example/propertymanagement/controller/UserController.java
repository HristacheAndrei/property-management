package com.example.propertymanagement.controller;

import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.service.implementations.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping("/createuser")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO responseUserDTO = userServiceImp.register(userDTO);
        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO userDTO) {
        UserDTO responseUserDTO = userServiceImp.login(userDTO.getEmail(), userDTO.getPassword());
        if (responseUserDTO != null)
            return new ResponseEntity<>(responseUserDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
