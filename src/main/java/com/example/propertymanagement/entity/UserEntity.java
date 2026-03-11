package com.example.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="USER_TABLE") //if we don't put name it will take the name of PropertyEntity
public class UserEntity {
    @Id //we tell JPA this is a primary key column
    @GeneratedValue(strategy = GenerationType.AUTO) //this helps JPA to know that it has to generate automaticaly using the strategy
    private Long id; //primary key column for the column
    private String name;
    @Column(name="EMAIL", nullable = false)
    private String email;
    private String phone;
    private String password;
}
