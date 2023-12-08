package com.example.servicesforyou.services;
import com.example.servicesforyou.models.DTO.SellerDTO;
import com.example.servicesforyou.models.entity.SellersEntity;
import com.example.servicesforyou.models.mapper.SellerMapper;
import com.example.servicesforyou.repositories.SellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {
    @Mock
    private SellerRepository sellerRepository;
    @Mock
    private SellerMapper sellerMapper;
    @Mock
    private SellerService sellerService;

    @BeforeEach
    public void setUp() {

        sellerService = new SellerService(sellerRepository, sellerMapper);
    }

    @Test
    public void testGetAllSellers() {
        SellersEntity sellerEntity = new SellersEntity();
        sellerEntity.setId(Long.valueOf(1));
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setId(Long.valueOf(1));

        when(sellerRepository.findAll()).thenReturn(Collections.singletonList(sellerEntity));
        when(sellerMapper.sellerEntityToSellerDTO(sellerEntity)).thenReturn(sellerDTO);

        List<SellerDTO> allSellers = sellerService.getAllSellers();


        assertEquals(1, allSellers.size());
        assertEquals(Long.valueOf(1), allSellers.get(0).getId());
    }

    @Test
    public void testFindSellerById() {
        SellersEntity sellerEntity = new SellersEntity();
        sellerEntity.setId(Long.valueOf(1));
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setId(Long.valueOf(1));

        when(sellerRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(sellerEntity));
        when(sellerMapper.sellerEntityToSellerDTO(sellerEntity)).thenReturn(sellerDTO);

        Optional<SellerDTO> foundSeller = sellerService.findSellerById(1L);

        assertTrue(foundSeller.isPresent());
        assertEquals(Long.valueOf(1), foundSeller.get().getId());
    }

    @Test
    public void testDeleteSellerById() {
        sellerService.deleteSellerById(Long.valueOf(1));

        verify(sellerRepository, times(1)).deleteById(Long.valueOf(1));
    }
}
