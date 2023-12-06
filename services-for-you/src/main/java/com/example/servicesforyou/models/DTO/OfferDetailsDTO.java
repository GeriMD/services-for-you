package com.example.servicesforyou.models.DTO;

import com.example.servicesforyou.models.enums.ServicesCategoryEnum;

import java.math.BigDecimal;

public class OfferDetailsDTO {
    private Long id;

    private ServicesCategoryEnum category;
    private String description;
    private BigDecimal price;

    private String sellerPhone;
    private String sellerEmail;
    private String sellerFirstName;
    private String sellerLastName;
    private Integer sellerAge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerFullNameAndAge() {
        return sellerFirstName + " " + sellerLastName + " " + sellerAge;
    }

    public String getSellerPhoneAndEmail(){
        return sellerPhone + " " + sellerEmail;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerFirstName() {
        return sellerFirstName;
    }

    public void setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }

    public Integer getSellerAge() {
        return sellerAge;
    }

    public void setSellerAge(Integer sellerAge) {
        this.sellerAge = sellerAge;
    }
}
