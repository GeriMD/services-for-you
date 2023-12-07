package com.example.servicesforyou.services;

import com.example.servicesforyou.models.DTO.SellerDTO;
import com.example.servicesforyou.models.mapper.SellerMapper;
import com.example.servicesforyou.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;
    private final SellerMapper sellerMapper;

    public SellerService(SellerRepository sellerRepository, SellerMapper sellerMapper) {
        this.sellerRepository = sellerRepository;
        this.sellerMapper = sellerMapper;
    }

    public List<SellerDTO> getAllSellers(){
       return sellerRepository.findAll().stream().map(sellerMapper::sellerEntityToSellerDTO).toList();

    }

    public Optional<SellerDTO> findSellerById(Long id){
        return sellerRepository.findById(id).map(sellerMapper::sellerEntityToSellerDTO);
    }

    public void deleteSellerById(Long id){
        sellerRepository.deleteById(id);
    }
}
