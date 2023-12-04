package com.example.servicesforyou.services;

import com.example.servicesforyou.models.binding.RegisterBindingModel;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.RolesEnum;
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

    public void createUserIfNotExist(String email) {

        var userOpt = this.userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            UserEntity newUser = new UserEntity();
            newUser.setEmail(email);
            newUser.setPassword(null);
            newUser.setFirstName("New");
            newUser.setLastName("User");
            newUser.setUserRoles(List.of());


            userRepository.save(newUser);
        }
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



