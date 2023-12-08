package com.example.servicesforyou.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.servicesforyou.models.DTO.OfferDetailsDTO;
import com.example.servicesforyou.models.binding.AddOfferBindingModel;
import com.example.servicesforyou.models.entity.OfferEntity;
import com.example.servicesforyou.models.entity.SellersEntity;
import com.example.servicesforyou.models.mapper.OfferMapper;
import com.example.servicesforyou.repositories.OffersRepository;
import com.example.servicesforyou.repositories.SellerRepository;
import com.example.servicesforyou.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OfferServiceTest {
    @Mock

    private OffersRepository offersRepository;
    @Mock
    private SellerRepository sellerRepository;
    @Mock
    private UserRepository userRepository;

    @Mock
    private OfferMapper offerMapper;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private OfferService offerService;

    @BeforeEach
    public void setUp() {

        offerService = new OfferService(offersRepository, modelMapper, sellerRepository, offerMapper, userRepository);
    }

    @Test
    public void testIfItAddsOffer() {

        AddOfferBindingModel mockBindingModel = new AddOfferBindingModel();
        UserDetails mockUserDetails = new User("test@example.com", "123456", List.of());

        SellersEntity mockSeller = new SellersEntity();
        when(sellerRepository.findByEmail(mockUserDetails.getUsername())).thenReturn(Optional.of(mockSeller));

        OfferEntity mockOfferEntity = new OfferEntity();
        when(modelMapper.map(mockBindingModel, OfferEntity.class)).thenReturn(mockOfferEntity);

        offerService.addOffer(mockBindingModel, mockUserDetails);


        verify(offersRepository).save(mockOfferEntity);
    }

    @Test
    public void testItFindsOfferById() {
        Long id = Long.valueOf(1);
        OfferEntity mockOfferEntity = new OfferEntity();
        when(offersRepository.findById(id)).thenReturn(Optional.of(mockOfferEntity));
        when(offerMapper.offerEntityToOfferDetailsDto(mockOfferEntity)).thenReturn(new OfferDetailsDTO());

        Optional<OfferDetailsDTO> foundOffer = offerService.findOfferById(id);

        assertTrue(foundOffer.isPresent());
        assertNotNull(foundOffer.get());
    }

    @Test
    public void testIfItDeletesOfferById() {
        Long id = Long.valueOf(1);
        offerService.deleteOfferById(id);
        verify(offersRepository).deleteById(id);
    }

    @Test
    public void testGetAllOffers() {
        Pageable pageable = Pageable.unpaged();
        OfferEntity mockOfferEntity = new OfferEntity();
        when(offersRepository.findAll(pageable)).thenReturn(new PageImpl<>(Collections.singletonList(mockOfferEntity)));
        when(offerMapper.offerEntityToOfferDetailsDto(mockOfferEntity)).thenReturn(new OfferDetailsDTO());

        Page<OfferDetailsDTO> allOffers = offerService.getAllOffers(pageable);

        assertNotNull(allOffers);
        assertEquals(1, allOffers.getContent().size());
    }

}


