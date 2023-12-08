package com.example.servicesforyou.web;

import com.example.servicesforyou.models.binding.RegisterBindingModel;

import com.example.servicesforyou.models.enums.TownsEnum;
import com.example.servicesforyou.repositories.UserRepository;
import com.example.servicesforyou.services.RequestService;
import com.example.servicesforyou.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)

public class UserControllerTestIT {
    @Mock
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RequestService requestService;
    @Mock
    private UserController userController;

    @BeforeEach
    public void setUp() {

        userController = new UserController(userService, userRepository, requestService);
    }

    @Test
    public void testRegisterUser() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        RegisterBindingModel userModel = new RegisterBindingModel();
        userModel.setEmail("test@abv.bg");
        userModel.setPassword("123456");
        userModel.setConfirmPassword("123456");
        userModel.setAge(18);
        userModel.setFirstName("firstName");
        userModel.setPhoneNumber("0888888888");
        userModel.setLastName("lastName");
        userModel.setTown(TownsEnum.VIDIN);

        when(userService.findUserByEmail(any())).thenReturn(Optional.empty());

        mockMvc.perform(post("/users/register")
                        .flashAttr("userModel", userModel)
                        .param("password", userModel.getPassword())
                        .param("confirmPassword", userModel.getConfirmPassword())
                        .param("email", userModel.getEmail())
                        .param("firstName", userModel.getFirstName())
                        .param("lastName", userModel.getLastName())
                        .param("age", "18")
                        .param("town", userModel.getTown().name())
                        .param("phoneNumber", userModel.getPhoneNumber())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

}



