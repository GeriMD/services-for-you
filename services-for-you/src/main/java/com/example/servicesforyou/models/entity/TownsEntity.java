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



    public TownsEntity() {
    }

    public TownsEnum getTownName() {
        return townName;
    }

    public void setTownName(TownsEnum townName) {
        this.townName = townName;
    }


}
