package com.example.servicesforyou.models.DTO;

import com.example.servicesforyou.models.enums.ServicesCategoryEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OfferDetailsDTOTest {
    private OfferDetailsDTO offerDetailsDTO;

    @BeforeEach
    public void setUp() {
        offerDetailsDTO = new OfferDetailsDTO();
        offerDetailsDTO.setId(Long.valueOf(1));
        offerDetailsDTO.setCategory(ServicesCategoryEnum.CLEANING);
        offerDetailsDTO.setDescription("Test description");
        offerDetailsDTO.setPrice(BigDecimal.valueOf(100));
        offerDetailsDTO.setSellerFirstName("TestFirstName");
        offerDetailsDTO.setSellerLastName("TestLastName");
        offerDetailsDTO.setSellerAge(30);
        offerDetailsDTO.setSellerEmail("test@abv.bg");
        offerDetailsDTO.setSellerPhone("0888888888");
    }

    @Test
    public void testGetSellerFullNameAndAge() {
        assertEquals("TestFirstName TestLastName 30", offerDetailsDTO.getSellerFullNameAndAge());
    }

    @Test
    public void testGetSellerPhoneAndEmail() {
        assertEquals("0888888888 test@abv.bg", offerDetailsDTO.getSellerPhoneAndEmail());
    }


    @Test
    public void testGetCategory() {
        assertEquals(ServicesCategoryEnum.CLEANING, offerDetailsDTO.getCategory());
    }

    @Test
    public void testGetSellerEmail(){
        assertEquals("test@abv.bg", offerDetailsDTO.getSellerEmail());
    }

    @Test
    public void testGetSellerFirstName(){
        assertEquals("TestFirstName", offerDetailsDTO.getSellerFirstName());
    }

    @Test
    public void testGetSellerLastName(){
        assertEquals("TestLastName", offerDetailsDTO.getSellerLastName());
    }

    @Test
    public void testGetDescription(){
        offerDetailsDTO.setDescription("description");
        assertEquals("description", offerDetailsDTO.getDescription());
    }
}
