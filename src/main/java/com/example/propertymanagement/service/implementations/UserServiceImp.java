package com.example.propertymanagement.service.implementations;

import com.example.propertymanagement.convertor.UserConvertor;
import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.entity.UserEntity;
import com.example.propertymanagement.repository.UserRespository;
import com.example.propertymanagement.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRespository userRespository;

    private final UserConvertor userConvertor;
    public UserServiceImp(UserRespository userRespository, UserConvertor userConvertor) {
        this.userConvertor = userConvertor;
        this.userRespository = userRespository;
    }
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity savedUser =  userRespository.save(userConvertor.convertUserDTOToUserEntity(userDTO));
        return userConvertor.converUserEntityToUserDTO(savedUser);
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<UserEntity> user = userRespository.findByEmailAndPassword(email, password);
        return user.map(userConvertor::converUserEntityToUserDTO).orElse(null);
    }
}
