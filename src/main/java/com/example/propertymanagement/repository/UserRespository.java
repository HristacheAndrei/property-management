package com.example.propertymanagement.repository;

import com.example.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//entity and id type
@Repository
public interface UserRespository extends ListCrudRepository<UserEntity, Long> {
    //CrudRepository has some methods like saveEntity, saveAllEntities
    // findAllById,delete, deleteById, deleteAll, update, etc
    public Optional<UserEntity> findByEmailAndPassword(String email, String password);
    public Optional<UserEntity> findByPhone(String phone);
    public Optional<UserEntity> findByEmail(String email);
}

