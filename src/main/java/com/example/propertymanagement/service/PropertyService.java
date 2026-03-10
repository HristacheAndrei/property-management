package com.example.propertymanagement.service;

import com.example.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public List<PropertyDTO> getAllProperties();
    public PropertyDTO getProperty(Long id);
    public PropertyDTO changeProperty(Long id, PropertyDTO propertyDTO);

    public void deleteProperty(Long id);
    public void deletePropertyWithPrice(Long price);
}
