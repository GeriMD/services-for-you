package com.example.servicesforyou.web;

import com.example.servicesforyou.models.entity.OfferEntity;
import com.example.servicesforyou.models.entity.SellersEntity;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.enums.ServicesCategoryEnum;
import com.example.servicesforyou.models.enums.TownsEnum;
import com.example.servicesforyou.util.TestUserAndOffer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerTestIT {

    private static final String TEST_USER1_EMAIL = "user1@test.com";
    private static final String TEST_USER2_EMAIL = "user2@test.com";
    private static final String TEST_ADMIN_EMAIL = "admin@test.com";
    private static final String TEST_SELLER_EMAIL = "seller@example.com";


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TestUserAndOffer toCreateTestUserOrOffer;

    @BeforeEach
    void setUp() {
        toCreateTestUserOrOffer.cleanUp();

    }

    @AfterEach
    void tearDown() {
        toCreateTestUserOrOffer.cleanUp();
    }



    @Test
    void testIfAnonymousUserCanDeleteOffer() throws Exception {
        UserEntity owner = toCreateTestUserOrOffer.createUser("anonymous@abv.bg");
        OfferEntity offer = toCreateTestUserOrOffer.createOffer(owner);

        mockMvc.perform(
                        delete("/offer/{id}", offer.getId())
                                .with(csrf())
                ).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/users/login"));
    }


}
