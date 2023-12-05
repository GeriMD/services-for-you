package com.example.servicesforyou.models.mapper;

import com.example.servicesforyou.models.DTO.RequestDTO;
import com.example.servicesforyou.models.entity.RequestEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    RequestDTO requestEntityToRequestDTO(RequestEntity requestEntity);
}
