package com.tprice.userManagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class JavaTestConfig {

    @Value("${spring.message}")
    private String message;

    public String GetContextString(){
        return message;
    }
}
