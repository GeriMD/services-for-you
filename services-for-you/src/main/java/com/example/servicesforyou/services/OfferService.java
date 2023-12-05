package com.example.servicesforyou.services;

import com.example.servicesforyou.models.DTO.OfferDetailsDTO;
import com.example.servicesforyou.models.binding.AddOfferBindingModel;
import com.example.servicesforyou.models.entity.OfferEntity;
import com.example.servicesforyou.models.entity.SellersEntity;
import com.example.servicesforyou.models.mapper.OfferMapper;
import com.example.servicesforyou.repositories.OffersRepository;
import com.example.servicesforyou.repositories.SellerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {

    private final OffersRepository offersRepository;
    private final ModelMapper modelMapper;
    private final SellerRepository sellerRepository;
    private final OfferMapper offerMapper;

    public OfferService(OffersRepository offersRepository, ModelMapper modelMapper, SellerRepository sellerRepository, OfferMapper offerMapper) {
        this.offersRepository = offersRepository;
        this.modelMapper = modelMapper;
        this.sellerRepository = sellerRepository;
        this.offerMapper = offerMapper;
    }

    public void addOffer(AddOfferBindingModel addOfferBindingModel, UserDetails userDetails) {
        OfferEntity newOffer = modelMapper.map(addOfferBindingModel, OfferEntity.class);

        SellersEntity seller = sellerRepository.findByEmail(userDetails.getUsername()).
                orElseThrow();


        newOffer.setSeller(seller);

        offersRepository.save(newOffer);
    }

    public Optional<OfferDetailsDTO> findOfferById(Long id) {
        return offersRepository.findById(id).map(offerMapper::offerEntityToOfferDetailsDto);
    }

    public void deleteOfferById(Long id) {
        offersRepository.deleteById(id);
    }

    public Page<OfferDetailsDTO> getAllOffers(Pageable pageable) {
        return offersRepository.findAll(pageable).map(offerMapper::offerEntityToOfferDetailsDto);
    }

    //TODO: ADD ADMIN IN SELLERS TABLE DEFAULT!
}
