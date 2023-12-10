package com.example.servicesforyou.web;
import static org.mockito.Mockito.*;


import com.example.servicesforyou.services.RequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {
    @Mock
    private RequestService requestService;
    @Mock
    private AdminPanelController adminPanelController;

    @BeforeEach
    public void setUp() {

        adminPanelController = new AdminPanelController(requestService);
    }


        @Test
        public void testDeleteOffer() throws Exception {

            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(adminPanelController).build();

            mockMvc.perform(delete("/admin/all/requests/{id}", Long.valueOf(1)))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/admin/all/requests"));

            verify(requestService, times(1)).deleteRequestById(Long.valueOf(1));
        }

        @Test
        public void testConfirmRequest() throws Exception {

            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(adminPanelController).build();

            mockMvc.perform(post("/admin/all/requests/{id}", Long.valueOf(1)))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/admin/all/requests"));

            verify(requestService, times(1)).confirmRequest(Long.valueOf(1));
        }


    }

