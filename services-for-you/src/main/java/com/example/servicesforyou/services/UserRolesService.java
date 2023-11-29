package com.example.servicesforyou.services;

import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.RolesEnum;
import com.example.servicesforyou.repositories.UserRolesRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRolesService {

    private final UserRolesRepository rolesRepository;

    public UserRolesService(UserRolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public void initUserRoles(){
        if (rolesRepository.count() != 0){
            return;
        }

        Arrays.stream(RolesEnum.values()).forEach(
               userRole -> {
                   UserRolesEntity role = new UserRolesEntity();
                   role.setUserRole(userRole);

                   rolesRepository.save(role);
               }
        );
    }


}
