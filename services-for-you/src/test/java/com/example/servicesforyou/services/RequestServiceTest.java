package com.example.servicesforyou.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.servicesforyou.models.DTO.RequestDTO;
import com.example.servicesforyou.models.binding.SendRequestBindingModel;
import com.example.servicesforyou.models.entity.RequestEntity;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.RolesEnum;
import com.example.servicesforyou.models.enums.TownsEnum;
import com.example.servicesforyou.models.mapper.RequestMapper;
import com.example.servicesforyou.repositories.RequestRepository;
import com.example.servicesforyou.repositories.SellerRepository;
import com.example.servicesforyou.repositories.UserRepository;
import com.example.servicesforyou.repositories.UserRolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {

    @Mock
    private ModelMapper modelMapper;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RequestRepository requestRepository;
    @Mock
    private RequestMapper requestMapper;
    @Mock
    private SellerRepository sellerRepository;
    @Mock
    private UserRolesRepository rolesRepository;
    @Mock
    private RequestService requestService;

    @BeforeEach
    public void setUp() {

        requestService = new RequestService(modelMapper, userRepository, requestRepository, requestMapper, sellerRepository, rolesRepository);
    }

    @Test
    public void testIfItAddsRequest() {
        SendRequestBindingModel mockRequestModel = new SendRequestBindingModel();
        RequestEntity mockRequestEntity = new RequestEntity();

        UserEntity mockUserEntity = new UserEntity();
        mockUserEntity.setId(Long.valueOf(1));
        mockUserEntity.setEmail("test@example.com");
        mockUserEntity.setTown(TownsEnum.VIDIN);


        when(modelMapper.map(mockRequestModel, RequestEntity.class)).thenReturn(mockRequestEntity);
        when(userRepository.findByEmail(mockRequestEntity.getEmail())).thenReturn(Optional.of(mockUserEntity));

        requestService.addRequest(mockRequestModel);

        verify(requestRepository).save(mockRequestEntity);
    }

    @Test
    public void testIfItWillReturnAllRequests() {
        Pageable pageable = Pageable.unpaged();

        when(requestRepository.findAll(pageable)).thenReturn(Page.empty());

        Page<RequestDTO> allRequests = requestService.getAllRequests(pageable);

        assertNotNull(allRequests);
        assertTrue(allRequests.isEmpty());
    }

    @Test
    public void testIfItDeletesById() {
        Long id =Long.valueOf(1);

        requestService.deleteRequestById(id);

        verify(requestRepository).deleteById(id);
    }

    @Test
    public void testConfirmRequest() {
        Long id = Long.valueOf(1);

        RequestEntity mockRequestEntity = new RequestEntity();
        mockRequestEntity.setUserId(Long.valueOf(1));

        UserEntity mockUserEntity = new UserEntity();
        mockUserEntity.setId(1L);
        mockUserEntity.setEmail("test@example.com");
        mockUserEntity.setAge(18);

        when(requestRepository.findById(id)).thenReturn(Optional.of(mockRequestEntity));
        when(userRepository.findById(mockRequestEntity.getUserId())).thenReturn(Optional.of(mockUserEntity));
        when(rolesRepository.findByRole(RolesEnum.SELLER)).thenReturn(Optional.of(new UserRolesEntity()));

        requestService.confirmRequest(id);

        verify(sellerRepository).save(any());
        verify(requestRepository).deleteById(id);
    }

    @Test
    public void testDeleteAllRequests() {
        requestService.deleteAllRequests();

        verify(requestRepository).deleteAll();
    }

}
