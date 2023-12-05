package com.example.servicesforyou.models.DTO;

import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.TownsEnum;

import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private List<UserRolesEntity> roles;
    private TownsEnum town;
    private Integer age;

    public TownsEnum getTown() {
        return town;
    }

    public void setTown(TownsEnum town) {
        this.town = town;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public TownsEnum getTownsEnum() {
        return town;
    }

    public void setTownsEnum(TownsEnum townsEnum) {
        this.town = townsEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<UserRolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRolesEntity> roles) {
        this.roles = roles;
    }
}
