package com.example.servicesforyou.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.servicesforyou.models.DTO.UserDTO;
import com.example.servicesforyou.models.binding.RegisterBindingModel;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.TownsEnum;
import com.example.servicesforyou.models.mapper.UserMapper;
import com.example.servicesforyou.repositories.SellerRepository;
import com.example.servicesforyou.repositories.UserRepository;
import com.example.servicesforyou.repositories.UserRolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserDetailsService userDetailsService;
    @Mock
    private UserRolesRepository rolesRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserService userService;
    @Mock
    private SellerRepository sellerRepository;

    @BeforeEach
    public void setUp() {
        userService = new UserService(passwordEncoder, userRepository, userDetailsService, rolesRepository, modelMapper, userMapper, sellerRepository);
    }


    @Test
    public void testFindUserByEmail() {
        String email = "test@abv.bg";
        UserDTO mockUserDTO = new UserDTO();
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(new UserEntity()));
        when(userMapper.offerEntityToUserDTO(any())).thenReturn(mockUserDTO);

        Optional<UserDTO> foundUser = userService.findUserByEmail(email);

        assertTrue(foundUser.isPresent());
        assertNotNull(foundUser.get());
        assertEquals(mockUserDTO, foundUser.get());
    }

    @Test
    public void testCreateAdminIfNotExist() {

        when(userRepository.count()).thenReturn(0L);
        when(rolesRepository.findByRole(any())).thenReturn(Optional.of(new UserRolesEntity()));

        userService.createAdminIfNotExist();


        verify(userRepository, times(1)).save(any());
        verify(sellerRepository, times(1)).save(any());
    }



}