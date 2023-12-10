package com.example.servicesforyou.models.binding;

import com.example.servicesforyou.models.entity.SellersEntity;
import com.example.servicesforyou.models.enums.ServicesCategoryEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public class AddOfferBindingModel {

    @NotNull
    @Enumerated(EnumType.STRING)
    private ServicesCategoryEnum category;

    @NotNull
    @Size(min = 5)
    private String description;

    @NotNull
    @Positive
    private double price;

    private boolean haveErrors;

    public boolean isHaveErrors() {
        return haveErrors;
    }

    public void setHaveErrors(boolean haveErrors) {
        this.haveErrors = haveErrors;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
