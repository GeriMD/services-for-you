package com.example.servicesforyou.services.impl;

import com.example.servicesforyou.services.RequestService;
import com.example.servicesforyou.services.ScheduledService;

public class ScheduledServiceImpl implements ScheduledService {
    private final RequestService requestService;

    public ScheduledServiceImpl(RequestService requestService) {

        this.requestService = requestService;
    }

    @Override
    public void deleteAllRequests() {
        requestService.deleteAllRequests();
    }
}
