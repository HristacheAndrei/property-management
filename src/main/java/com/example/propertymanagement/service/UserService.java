package com.example.propertymanagement.service;

import com.example.propertymanagement.dto.UserDTO;

public interface UserService {
    UserDTO register (UserDTO userDTO);
    UserDTO login (String email, String password);
}
