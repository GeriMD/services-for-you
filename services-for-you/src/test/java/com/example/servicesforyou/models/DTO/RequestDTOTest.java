package com.example.servicesforyou.models.DTO;

import com.example.servicesforyou.models.enums.TownsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class RequestDTOTest {
    private RequestDTO requestDTO;

    @BeforeEach
    public void setUp() {
        requestDTO = new RequestDTO();
        requestDTO.setId(Long.valueOf(1));
        requestDTO.setEmail("test@abv.bg");
        requestDTO.setFirstName("TestFirstName");
        requestDTO.setLastName("TestLastName");
        requestDTO.setTown(TownsEnum.VIDIN);
    }

    @Test
    public void testSetAndGetId(){
        requestDTO.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), requestDTO.getId());
    }
    @Test
    public void testSetAndGetEmail(){
        requestDTO.setEmail("test@abv.bg");
        assertEquals("test@abv.bg", requestDTO.getEmail());
    }

    @Test
    public void testSetAndGetFirstName(){
        requestDTO.setFirstName("TestFirstName");
        assertEquals("TestFirstName", requestDTO.getFirstName());
    }

    @Test
    public void testSetAndGetLastName(){
        requestDTO.setLastName("TestLastName");
        assertEquals("TestLastName", requestDTO.getLastName());
    }

    @Test
    public void testSetAndGetTown(){
        requestDTO.setTown(TownsEnum.VIDIN);
        assertEquals(TownsEnum.VIDIN, requestDTO.getTown());
    }


}
