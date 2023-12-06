package com.example.servicesforyou.services;

import com.example.servicesforyou.models.DTO.RequestDTO;
import com.example.servicesforyou.models.binding.SendRequestBindingModel;
import com.example.servicesforyou.models.entity.RequestEntity;
import com.example.servicesforyou.models.entity.SellersEntity;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.RolesEnum;
import com.example.servicesforyou.models.mapper.RequestMapper;
import com.example.servicesforyou.repositories.RequestRepository;
import com.example.servicesforyou.repositories.SellerRepository;
import com.example.servicesforyou.repositories.UserRepository;
import com.example.servicesforyou.repositories.UserRolesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;
    private final SellerRepository sellerRepository;
    private final UserRolesRepository rolesRepository;

    public RequestService(ModelMapper modelMapper, UserRepository userRepository, RequestRepository requestRepository, RequestMapper requestMapper, SellerRepository sellerRepository, UserRolesRepository rolesRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
        this.requestMapper = requestMapper;
        this.sellerRepository = sellerRepository;

        this.rolesRepository = rolesRepository;
    }

    public void addRequest(SendRequestBindingModel requestModel) {
        RequestEntity request = modelMapper.map(requestModel, RequestEntity.class);
        UserEntity user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        request.setUserId(user.getId());
        request.setTown(user.getTown());

        requestRepository.save(request);
    }


    public Page<RequestDTO> getAllRequests(Pageable pageable) {
        return requestRepository.findAll(pageable).map(requestMapper::requestEntityToRequestDTO);
    }

    public void deleteRequestById(Long id) {
        requestRepository.deleteById(id);
    }

    public void confirmRequest(Long id) {
        RequestEntity request = requestRepository.findById(id).orElseThrow();
        UserEntity user = userRepository.findById(request.getUserId()).orElseThrow();

        SellersEntity seller = new SellersEntity();
        seller.setId(user.getId());
        seller.setEmail(user.getEmail());
        seller.setFirstName(user.getFirstName());
        seller.setLastName(user.getLastName());
        seller.setAge(user.getAge());
        seller.setPhoneNumber(user.getPhoneNumber());


        sellerRepository.save(seller);

        String roleStringSeller = "SELLER";
        RolesEnum sellerRole = RolesEnum.valueOf(roleStringSeller);
        UserRolesEntity roleSeller = rolesRepository.findByRole(sellerRole).orElseThrow();

        user.getUserRoles().add(roleSeller);

        requestRepository.deleteById(id);

    }

    public void deleteAllRequests() {
        requestRepository.deleteAll();
    }
}
