package com.example.servicesforyou.models.mapper;

import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.DTO.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO offerEntityToUserDTO(UserEntity userEntity);
}
