package com.example.servicesforyou.services;

import com.example.servicesforyou.models.binding.AddOfferBindingModel;
import com.example.servicesforyou.models.entity.OfferEntity;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.repositories.OffersRepository;
import com.example.servicesforyou.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OffersRepository offersRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public OfferService(OffersRepository offersRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.offersRepository = offersRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void addOffer(AddOfferBindingModel addOfferBindingModel, UserDetails userDetails) {
        OfferEntity newOffer = modelMapper.map(addOfferBindingModel, OfferEntity.class);

        UserEntity seller = userRepository.findByEmail(userDetails.getUsername()).
                orElseThrow();


        newOffer.setSeller(seller);

        offersRepository.save(newOffer);
    }

}
