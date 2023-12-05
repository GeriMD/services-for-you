package com.example.servicesforyou.models.mapper;

import com.example.servicesforyou.models.DTO.OfferDetailsDTO;
import com.example.servicesforyou.models.entity.OfferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    @Mapping(source = "seller.firstName", target = "sellerFirstName")
    @Mapping(source = "seller.lastName", target = "sellerLastName")
    @Mapping(source = "seller.email", target = "sellerEmail")
    @Mapping(source = "seller.phoneNumber", target = "sellerPhone")
    @Mapping(source = "seller.age", target = "sellerAge")
    OfferDetailsDTO offerEntityToOfferDetailsDto(OfferEntity offerEntity);
}
