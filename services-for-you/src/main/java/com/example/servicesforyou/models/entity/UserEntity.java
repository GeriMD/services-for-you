package com.example.servicesforyou.models.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private int age;

}
