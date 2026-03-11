package com.example.propertymanagement.convertor;

import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {
    public UserDTO converUserEntityToUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }
    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setName(userDTO.getName());
        userEntity.setPhone(userDTO.getPhone());
        return userEntity;
    }
}
