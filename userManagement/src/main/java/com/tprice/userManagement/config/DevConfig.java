package com.tprice.userManagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Configuration
@Component
public class DevConfig {

    @Value("${spring.message}")
    private String contextString;

    public String getContextString(){
        return this.contextString;
    }
}
