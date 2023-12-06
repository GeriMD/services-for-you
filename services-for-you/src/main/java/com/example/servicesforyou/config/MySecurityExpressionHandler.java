package com.example.servicesforyou.config;

import com.example.servicesforyou.services.OfferService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class MySecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    private final OfferService offerService;

    public MySecurityExpressionHandler(OfferService offerService) {
        this.offerService = offerService;
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
        OwnerSecurityExpression securityExpression = new OwnerSecurityExpression(authentication, offerService);

        securityExpression.setPermissionEvaluator(getPermissionEvaluator());
        securityExpression.setTrustResolver(new AuthenticationTrustResolverImpl());
        securityExpression.setRoleHierarchy(getRoleHierarchy());
        return securityExpression;
    }
}
