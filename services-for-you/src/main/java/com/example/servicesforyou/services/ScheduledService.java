package com.example.servicesforyou.services;

import org.springframework.scheduling.annotation.Scheduled;

public interface ScheduledService {

    @Scheduled(cron = "0 0 23 ? * FRI *")
    void deleteAllRequests();
}
