package com.example.propertymanagement.service.implementations;

import com.example.propertymanagement.convertor.UserConvertor;
import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.entity.UserEntity;
import com.example.propertymanagement.repository.UserRespository;
import com.example.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private UserConvertor userConvertor;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity savedUser =  userRespository.save(userConvertor.convertUserDTOToUserEntity(userDTO));
        return userConvertor.converUserEntityToUserDTO(savedUser);
    }

    @Override
    public UserDTO login(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) return null;
        List<UserEntity> allUsers = userRespository.findAll();
        UserEntity myUser = allUsers.stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password)).toList().get(0);

        if (myUser != null) {
            return userConvertor.converUserEntityToUserDTO(myUser);
        }
        return null;
    }
}
