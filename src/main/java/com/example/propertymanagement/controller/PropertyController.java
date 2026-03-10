package com.example.propertymanagement.controller;

import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.service.PropertyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> propertyDTOList = propertyService.getAllProperties();
        if (propertyDTOList.isEmpty())
            return new ResponseEntity<>(propertyDTOList, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(propertyDTOList, HttpStatus.OK);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<PropertyDTO> getProperty(@PathVariable Long id) {
        PropertyDTO propertyDTO = propertyService.getProperty(id);
        if (propertyDTO != null)
            return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(propertyDTO, HttpStatus.NOT_FOUND);
    }
    @PutMapping("/change/{id}")
    public ResponseEntity<PropertyDTO> changeProperty(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
        PropertyDTO newPropertyDTO = propertyService.changeProperty(id, propertyDTO);
        return new ResponseEntity<>(newPropertyDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PropertyDTO> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<PropertyDTO> deletePropertyWithPrice(@RequestBody Long price) {
        propertyService.deletePropertyWithPrice(price);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
