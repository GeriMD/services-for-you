package com.example.servicesforyou.models.DTO;

import com.example.servicesforyou.models.enums.TownsEnum;

public class RequestDTO {

    private Long id;

    private String email;
    private String firstName;
    private String lastName;
    private TownsEnum town;

    public TownsEnum getTown() {
        return town;
    }

    public void setTown(TownsEnum town) {
        this.town = town;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
