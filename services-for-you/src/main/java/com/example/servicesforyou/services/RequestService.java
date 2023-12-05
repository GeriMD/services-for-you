package com.example.servicesforyou.services;

import com.example.servicesforyou.models.DTO.RequestDTO;
import com.example.servicesforyou.models.binding.SendRequestBindingModel;
import com.example.servicesforyou.models.entity.RequestEntity;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.mapper.RequestMapper;
import com.example.servicesforyou.repositories.RequestRepository;
import com.example.servicesforyou.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;

    public RequestService(ModelMapper modelMapper, UserRepository userRepository, RequestRepository requestRepository, RequestMapper requestMapper) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
        this.requestMapper = requestMapper;
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
}
