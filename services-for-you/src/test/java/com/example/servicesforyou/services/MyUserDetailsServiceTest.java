package com.example.servicesforyou.services;

import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.RolesEnum;
import com.example.servicesforyou.models.enums.TownsEnum;
import com.example.servicesforyou.repositories.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MyUserDetailsServiceTest {
    @Mock
    private UserRepository userRepositoryMock;

    private MyUserDetailsService testService;

    @BeforeEach
    void setUp(){
        testService = new MyUserDetailsService(userRepositoryMock);
    }

    @Test
    public void testLoadUserByUsernameIfUserExists(){

        UserEntity testUser = new UserEntity();

        testUser.setEmail("test@abv.bg");
        testUser.setPassword("testpass");
        testUser.setFirstName("Tester");
        testUser.setLastName("Testerov");
        testUser.setTown(TownsEnum.VIDIN);
        testUser.setAge(21);
        testUser.setPhoneNumber("0888888888");
        testUser.setUserRoles(List.of(
            //    new UserRolesEntity().setUserRole(RolesEnum.ADMIN),
            //    new UserRolesEntity().setUserRole(RolesEnum.USER),
           //     new UserRolesEntity().setUserRole(RolesEnum.SELLER)

        ));


    }
}
