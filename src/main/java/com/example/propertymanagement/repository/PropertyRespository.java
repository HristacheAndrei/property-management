package com.example.propertymanagement.repository;

import com.example.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

//entity and id type
@Repository
public interface PropertyRespository extends ListCrudRepository<PropertyEntity, Long> {
    //CrudRepository has some methods like saveEntity, saveAllEntities
    // findAllById,delete, deleteById, deleteAll, update, etc

}

