package com.example.servicesforyou.services;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MaintenanceTest {

    @Test
    public void testIfItWillNotRedirectIfTheTimeIsNotBetween5And6() throws Exception {
        MaintenanceInterceptor interceptor = new MaintenanceInterceptor();
        HttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponse response = new MockHttpServletResponse();

        ((MockHttpServletRequest) request).setRequestURI("/some-url");
        LocalTime timeOutsideMaintenanceHours = LocalTime.of(7, 0);
        interceptor.preHandle(request, response, null);

        assertNull(((MockHttpServletResponse) response).getRedirectedUrl());
    }

    @Test
    public void testIfItWillRedirectIfTheTimeIsBetween5And6() throws Exception {
        MaintenanceInterceptor interceptor = new MaintenanceInterceptor();
        HttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponse response = new MockHttpServletResponse();

        ((MockHttpServletRequest) request).setRequestURI("/maintenance");
        LocalTime timeInMaintenanceHours = LocalTime.of(5, 30);
        interceptor.preHandle(request, response, null);


        assertNull(((MockHttpServletResponse) response).getRedirectedUrl());
    }
}
