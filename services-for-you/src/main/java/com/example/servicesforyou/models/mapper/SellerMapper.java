package com.example.servicesforyou.models.mapper;

import com.example.servicesforyou.models.DTO.SellerDTO;
import com.example.servicesforyou.models.entity.SellersEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    SellerDTO sellerEntityToSellerDTO(SellersEntity sellersEntity);
}
