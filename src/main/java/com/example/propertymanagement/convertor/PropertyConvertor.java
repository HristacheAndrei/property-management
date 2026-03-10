package com.example.propertymanagement.convertor;

import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConvertor {
    public PropertyEntity convertPropertyDTOToPropertyEntity(PropertyDTO propertyDTO) {
        PropertyEntity pe = new PropertyEntity();

        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setPrice(propertyDTO.getPrice());
        pe.setAddress(propertyDTO.getAddress());

        return pe;
    }
    public PropertyDTO convertPropertyEntityToPropertyDTO(PropertyEntity propertyEntity) {
        PropertyDTO pd = new PropertyDTO();

        pd.setId(propertyEntity.getId());
        pd.setTitle(propertyEntity.getTitle());
        pd.setDescription(propertyEntity.getDescription());
        pd.setOwnerName(propertyEntity.getOwnerName());
        pd.setOwnerEmail(propertyEntity.getOwnerEmail());
        pd.setPrice(propertyEntity.getPrice());
        pd.setAddress(propertyEntity.getAddress());

        return pd;
    }
    public PropertyEntity completePropertyEntityFromDTO(PropertyDTO propertyDTO, PropertyEntity propertyEntity) {
        if (!propertyDTO.getTitle().isEmpty())
            propertyEntity.setTitle(propertyDTO.getTitle());
        if (!propertyDTO.getDescription().isEmpty())
            propertyEntity.setDescription(propertyDTO.getDescription());
        if (!propertyDTO.getOwnerEmail().isEmpty())
            propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        if (propertyDTO.getPrice() != null)
            propertyEntity.setPrice(propertyDTO.getPrice());
        if (!propertyDTO.getAddress().isEmpty())
            propertyEntity.setAddress(propertyDTO.getAddress());
        return propertyEntity;
    }

}
