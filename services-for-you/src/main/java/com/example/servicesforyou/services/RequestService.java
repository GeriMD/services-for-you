package com.example.servicesforyou.services;

import com.example.servicesforyou.models.binding.SendRequestBindingModel;
import com.example.servicesforyou.models.entity.RequestEntity;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.repositories.RequestRepository;
import com.example.servicesforyou.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RequestRepository requestRepository;

    public RequestService(ModelMapper modelMapper, UserRepository userRepository, RequestRepository requestRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
    }

    public void addRequest(SendRequestBindingModel requestModel){
        RequestEntity request = modelMapper.map(requestModel, RequestEntity.class);
        UserEntity user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        request.setUserId(user.getId());
        request.setTown(user.getTown());

        requestRepository.save(request);
    }
}
