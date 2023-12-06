package com.example.servicesforyou.config;

import com.example.servicesforyou.services.OfferService;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

public class OwnerSecurityExpression extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private final Authentication authentication;
    private Object filterObject;
    private Object returnObject;
    private final OfferService offerService;

    public OwnerSecurityExpression(Authentication authentication, OfferService offerService) {
        super(authentication);
        this.authentication = authentication;
        this.offerService = offerService;
    }

    public boolean isOwnerOrAdmin(Long id) {
        if (authentication.getPrincipal() == null) {
            return false;
        }

        var email = authentication.getName();

        return offerService.isOwnerOrAdmin(email, id);

    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;

    }

    @Override
    public Object getFilterObject() {
        return this.filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;

    }

    @Override
    public Object getReturnObject() {
        return this.returnObject;
    }

    @Override
    public Object getThis() {
        return this;
    }
}
