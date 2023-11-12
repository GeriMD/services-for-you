package com.example.servicesforyou.models.entity;

import com.example.servicesforyou.models.enums.RolesEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRolesEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RolesEnum userRole;

    public RolesEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(RolesEnum userRole) {
        this.userRole = userRole;
    }
}
