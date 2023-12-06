package com.example.servicesforyou.models.binding;

import com.example.servicesforyou.models.enums.TownsEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterBindingModel {

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @Email
    @Size(min = 2,max = 30)
    private String email;

    @NotNull
    @Size(min = 9)
    private String phoneNumber;

    @NotNull
    private int age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TownsEnum town;

    public TownsEnum getTown() {
        return town;
    }

    public void setTown(TownsEnum town) {
        this.town = town;
    }

    @NotNull
    @Size(min = 6)
    private String password;


    @Size(min = 6)
    @NotNull
    private String confirmPassword;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
