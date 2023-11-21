package com.example.servicesforyou.models.entity;


import com.example.servicesforyou.models.enums.TownsEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "towns")
public class TownsEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TownsEnum townName;

    @OneToMany
    private List<UserEntity> userTown = new ArrayList<>();

    @OneToMany
    private List<OfferEntity> offers = new ArrayList<>();

    public TownsEntity() {
    }

    public TownsEnum getTownName() {
        return townName;
    }

    public void setTownName(TownsEnum townName) {
        this.townName = townName;
    }

    public List<UserEntity> getUserTown() {
        return userTown;
    }

    public void setUserTown(List<UserEntity> userTown) {
        this.userTown = userTown;
    }

    public List<OfferEntity> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferEntity> offers) {
        this.offers = offers;
    }
}
