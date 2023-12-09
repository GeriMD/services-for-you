package com.example.servicesforyou.models.DTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;

public class SellerDTOTest {
    private SellerDTO sellerDTO;

    @BeforeEach
    public void setUp() {
        sellerDTO = new SellerDTO();
    sellerDTO.setEmail("test@abv.bg");
    sellerDTO.setPhoneNumber("0888888888");
    sellerDTO.setId(Long.valueOf(1));
    sellerDTO.setFirstName("fName");
    sellerDTO.setLastName("lName");
    }

    @Test
    public void testGetId(){
        assertEquals(Long.valueOf(1), sellerDTO.getId());
    }

    @Test
    public void testGetEmail(){
        assertEquals("test@abv.bg", sellerDTO.getEmail());
    }

    @Test
    public void testGetFirstName(){
        sellerDTO.setFirstName("test");
        assertEquals("test", sellerDTO.getFirstName());
    }
}
