package com.example.servicesforyou.config;

import com.example.servicesforyou.services.OfferService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    private final OfferService offerService;

    public MyMethodSecurityConfig(OfferService offerService) {
        this.offerService = offerService;
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new MySecurityExpressionHandler(offerService);
    }
}
