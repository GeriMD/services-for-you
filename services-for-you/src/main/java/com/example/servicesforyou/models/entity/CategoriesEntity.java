package com.example.servicesforyou.models.entity;

import com.example.servicesforyou.models.enums.ServicesCategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoriesEntity extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ServicesCategoryEnum categories;

    public CategoriesEntity() {
    }

    public ServicesCategoryEnum getCategories() {
        return categories;
    }

    public void setCategories(ServicesCategoryEnum categories) {
        this.categories = categories;
    }
}
