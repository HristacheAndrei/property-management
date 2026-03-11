package com.example.propertymanagement.repository;

import com.example.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

//entity and id type
public interface UserRespository extends ListCrudRepository<UserEntity, Long> {
    //CrudRepository has some methods like saveEntity, saveAllEntities
    // findAllById,delete, deleteById, deleteAll, update, etc
}

