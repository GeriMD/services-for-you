package com.example.servicesforyou.models.entity;

import com.example.servicesforyou.models.enums.ServicesCategoryEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {


    private String description;
    private double price;

    @ManyToOne
    private UserEntity seller;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServicesCategoryEnum category;



    public OfferEntity() {
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public ServicesCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(ServicesCategoryEnum category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }
}
