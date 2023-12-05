package com.example.servicesforyou.models.entity;

import com.example.servicesforyou.models.enums.ServicesCategoryEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {


    private String description;
    private BigDecimal price;

    @ManyToOne
    private SellersEntity seller;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServicesCategoryEnum category;


    public OfferEntity() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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


    public SellersEntity getSeller() {
        return seller;
    }

    public void setSeller(SellersEntity seller) {
        this.seller = seller;
    }
}
