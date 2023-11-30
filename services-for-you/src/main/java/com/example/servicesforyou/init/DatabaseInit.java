package com.example.servicesforyou.init;

import com.example.servicesforyou.services.TownsService;
import com.example.servicesforyou.services.UserRolesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final UserRolesService rolesService;
    private final TownsService townsService;


    public DatabaseInit( UserRolesService rolesService, TownsService townsService) {

        this.rolesService = rolesService;
        this.townsService = townsService;
    }

    @Override
    public void run(String... args) throws Exception {
        rolesService.initUserRoles();
        townsService.initTowns();


    }

}
