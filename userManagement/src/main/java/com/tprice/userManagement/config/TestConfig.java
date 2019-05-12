package com.tprice.userManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig{

    @Value("${spring.message}")
    private String contextString;

    public String getContextString(){
        return this.contextString;
    }
}
