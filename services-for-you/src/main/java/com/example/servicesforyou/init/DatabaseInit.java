package com.example.servicesforyou.init;

import com.example.servicesforyou.services.CategoriesService;
import com.example.servicesforyou.services.UserRolesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final CategoriesService categoriesService;
    private final UserRolesService rolesService;

    public DatabaseInit(CategoriesService categoriesService, UserRolesService rolesService) {
        this.categoriesService = categoriesService;
        this.rolesService = rolesService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoriesService.initCategories();
        rolesService.initUserRoles();

    }
}
