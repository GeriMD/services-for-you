package com.example.servicesforyou.models.entity;


import javax.persistence.*;

@Entity
@Table(name = "towns")
public class TownsEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private String townName;
}
