package com.example.servicesforyou.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sellers")
public class SellersEntity extends BaseEntity{

    private String firstName;
    private String lastName;
    private int age;

}
