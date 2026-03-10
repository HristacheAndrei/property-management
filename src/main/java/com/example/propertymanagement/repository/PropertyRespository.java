package com.example.propertymanagement.repository;

import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

//entity and id type
public interface PropertyRespository extends ListCrudRepository<PropertyEntity, Long> {
    //CrudRepository has some methods like saveEntity, saveAllEntities
    // findAllById,delete, deleteById, deleteAll, update, etc
}

