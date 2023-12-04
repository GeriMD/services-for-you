package com.example.servicesforyou.models.binding;

import com.example.servicesforyou.models.enums.TownsEnum;

import javax.validation.constraints.NotNull;

public class SendRequestBindingModel {

    @NotNull
    private String email;

    @NotNull
    private String firstName;
    private String lastName;

    private String description;
    @NotNull
    private TownsEnum town;

    public TownsEnum getTown() {
        return town;
    }

    public void setTown(TownsEnum town) {
        this.town = town;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
