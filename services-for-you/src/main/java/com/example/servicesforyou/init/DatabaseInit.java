package com.example.servicesforyou.init;

import com.example.servicesforyou.services.TownsService;
import com.example.servicesforyou.services.UserRolesService;
import com.example.servicesforyou.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final UserRolesService rolesService;
    private final TownsService townsService;
    private final UserService userService;


    public DatabaseInit(UserRolesService rolesService, TownsService townsService, UserService userService) {

        this.rolesService = rolesService;
        this.townsService = townsService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        rolesService.initUserRoles();
        townsService.initTowns();
        userService.createAdminIfNotExist();


    }

}
