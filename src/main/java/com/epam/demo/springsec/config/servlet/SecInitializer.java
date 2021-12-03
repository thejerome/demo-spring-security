package com.epam.demo.springsec.config.servlet;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecInitializer extends AbstractSecurityWebApplicationInitializer {
    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}