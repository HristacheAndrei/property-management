package com.example.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="PROPERTY_TABLE") //if we don't put name it will take the name of PropertyEntity
//this tells hibernate to convert this to a table in database
public class PropertyEntity {
    @Id //we tell JPA this is a primary key column
    @GeneratedValue(strategy = GenerationType.AUTO) //this helps JPA to know that it has to generate automaticaly using the strategy
    private Long id; //primary key column for the column
    @Column(name="PROPERTY_TITLE", nullable = false) //this is how we tell JPA that this is a column for PROPERTY_TITLE
    private String title; //2badroom appartment
    //if we put like this JPA will take the name of the column like description
    private String description; //

    private Double price;
    private String address;
}
