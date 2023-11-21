package com.example.servicesforyou.config;

import com.example.servicesforyou.services.MaintenanceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LocaleChangeInterceptor localeChangeInterceptor;
    private final MaintenanceInterceptor maintenanceInterceptor;

    public WebConfig(LocaleChangeInterceptor localeChangeInterceptor, MaintenanceInterceptor maintenanceInterceptor) {
        this.localeChangeInterceptor = localeChangeInterceptor;
        this.maintenanceInterceptor = maintenanceInterceptor;
    }
}
