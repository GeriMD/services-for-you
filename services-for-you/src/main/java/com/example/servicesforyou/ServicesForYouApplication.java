package com.example.servicesforyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServicesForYouApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicesForYouApplication.class, args);
    }

}
