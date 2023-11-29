package com.example.servicesforyou.init;

import com.example.servicesforyou.services.CategoriesService;
import com.example.servicesforyou.services.TownsService;
import com.example.servicesforyou.services.UserRolesService;
import com.example.servicesforyou.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final CategoriesService categoriesService;
    private final UserRolesService rolesService;
    private final TownsService townsService;


    public DatabaseInit(CategoriesService categoriesService, UserRolesService rolesService, TownsService townsService) {
        this.categoriesService = categoriesService;
        this.rolesService = rolesService;
        this.townsService = townsService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoriesService.initCategories();
        rolesService.initUserRoles();
        townsService.initTowns();


    }

}
