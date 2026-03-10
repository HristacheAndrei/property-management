package com.example.propertymanagement.service.implementations;

import com.example.propertymanagement.convertor.PropertyConvertor;
import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.entity.PropertyEntity;
import com.example.propertymanagement.repository.PropertyRespository;
import com.example.propertymanagement.service.PropertyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRespository propertyRespository;
    @Autowired
    private PropertyConvertor propertyConvertor;
    @Override
    @Transactional
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = propertyRespository.save(propertyConvertor.convertPropertyDTOToPropertyEntity(propertyDTO));
        return propertyConvertor.convertPropertyEntityToPropertyDTO(pe);
    }
    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propertyEntityList;
        propertyEntityList = propertyRespository.findAll();
        return propertyEntityList.stream()
                .map(propertyConvertor::convertPropertyEntityToPropertyDTO)
                .toList();
    }
    @Override
    public PropertyDTO getProperty(Long id) {
        PropertyEntity propertyEntity = propertyRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proprietatea cu ID-ul " + id + " nu există!"));
        return propertyConvertor.convertPropertyEntityToPropertyDTO(propertyEntity);
    }
    @Override
    public PropertyDTO changeProperty(Long id, PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proprietatea cu ID-ul " + id + " nu există!"));
        propertyEntity = propertyConvertor.completePropertyEntityFromDTO(propertyDTO, propertyEntity);
        propertyEntity = propertyRespository.save(propertyEntity);
        return propertyConvertor.convertPropertyEntityToPropertyDTO(propertyEntity);
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRespository.deleteById(id);
    }
    @Override
    public void deletePropertyWithPrice(Long price) {
        List<Long> ids = propertyRespository.findAll().stream()
                .filter(propertyEntity -> propertyEntity.getPrice() > 1000)
                .map(PropertyEntity::getId)
                .toList();
        propertyRespository.deleteAllById(ids);
    }


}
