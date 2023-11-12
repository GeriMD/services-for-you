package com.example.servicesforyou.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    private String description;
    private LocalDateTime dateOfAdding;

}
