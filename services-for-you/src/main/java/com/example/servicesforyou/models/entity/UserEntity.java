package com.example.servicesforyou.models.entity;


import com.example.servicesforyou.models.enums.TownsEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;


    private String lastName;

    @Column(nullable = false)
    private int age;
    private String imageUrl;

    @Column(nullable = false)
    private String phoneNumber;

    public TownsEnum getTown() {
        return town;
    }

    public void setTown(TownsEnum town) {
        this.town = town;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TownsEnum town;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRolesEntity> userRoles = new ArrayList<>();


    public UserEntity() {
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<UserRolesEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRolesEntity> userRoles) {
        this.userRoles = userRoles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
