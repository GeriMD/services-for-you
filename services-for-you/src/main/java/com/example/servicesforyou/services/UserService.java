package com.example.servicesforyou.services;

import com.example.servicesforyou.models.binding.RegisterBindingModel;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.RolesEnum;
import com.example.servicesforyou.models.enums.TownsEnum;
import com.example.servicesforyou.repositories.UserRepository;
import com.example.servicesforyou.repositories.UserRolesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private  PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private UserDetailsService userDetailsService;
    private final UserRolesRepository rolesRepository;

    private ModelMapper modelMapper;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, UserDetailsService userDetailsService, UserRolesRepository rolesRepository, ModelMapper modelMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.rolesRepository = rolesRepository;
        this.modelMapper = modelMapper;


    }

    public void registerAndLoginUser(RegisterBindingModel registerBindingModel){
     UserEntity user = modelMapper.map(registerBindingModel, UserEntity.class);
        user.setPassword(passwordEncoder.encode(registerBindingModel.getPassword()));
       String roleString = "USER";
       RolesEnum role = RolesEnum.valueOf(roleString);
       UserRolesEntity roleUser = rolesRepository.findByRole(role).orElseThrow();

        List<UserRolesEntity> roles = new ArrayList<>();
        roles.add(roleUser);
        user.setUserRoles(roles);


        userRepository.save(user);
        login(user.getEmail());

    }

    public void createAdminIfNotExist() {

        if (userRepository.count() != 0){
            return;
        }
        List<UserRolesEntity> rolesList = new ArrayList<>();
        String roleStringAdmin = "ADMIN";
        String roleStringUser = "USER";
        String roleStringSeller = "SELLER";

        RolesEnum adminRole = RolesEnum.valueOf(roleStringAdmin);
        RolesEnum userRole = RolesEnum.valueOf(roleStringUser);
        RolesEnum sellerRole = RolesEnum.valueOf(roleStringSeller);

        UserRolesEntity roleAdmin = rolesRepository.findByRole(adminRole).orElseThrow();
        UserRolesEntity roleUser = rolesRepository.findByRole(userRole).orElseThrow();
        UserRolesEntity roleSeller = rolesRepository.findByRole(sellerRole).orElseThrow();

        rolesList.add(roleAdmin);
        rolesList.add(roleUser);
        rolesList.add(roleSeller);


        UserEntity admin = new UserEntity();
        admin.setEmail("admin@abv.bg");
        admin.setFirstName("Admin");
        admin.setLastName("Adminov");
        admin.setAge(18);
        admin.setPhoneNumber("0888888888");
        admin.setPassword(passwordEncoder.encode("adminpass"));
        admin.setTown(TownsEnum.VIDIN);
        admin.setUserRoles(rolesList);
        userRepository.save(admin);

    }

    public void login(String email){

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.
                getContext().
                setAuthentication(auth);
    }


    }



