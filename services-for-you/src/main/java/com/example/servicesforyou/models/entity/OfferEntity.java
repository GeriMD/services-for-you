package com.example.servicesforyou.models.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {


    private String description;
    private LocalDateTime dateOfAdding;


    @ManyToOne

    private SellersEntity seller;



    @OneToOne
    private CategoriesEntity category;

    public OfferEntity() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateOfAdding() {
        return dateOfAdding;
    }

    public void setDateOfAdding(LocalDateTime dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }

    public SellersEntity getSeller() {
        return seller;
    }

    public void setSeller(SellersEntity seller) {
        this.seller = seller;
    }

    public CategoriesEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriesEntity category) {
        this.category = category;
    }
}
