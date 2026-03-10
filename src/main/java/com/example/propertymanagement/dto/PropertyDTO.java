package com.example.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
    private Long id;
    private String title; //2badroom appartment
    private String description; //
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;
}
