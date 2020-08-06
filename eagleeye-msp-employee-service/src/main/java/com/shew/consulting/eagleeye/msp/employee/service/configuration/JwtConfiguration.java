package com.shew.consulting.eagleeye.msp.employee.service.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * Configuration classes needed for Jwt token setup.
 */
@Configuration
public class JwtConfiguration {

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public String jwtSecret(@Value("${jwt.secret}") String secret) {
        return secret;
    }

}
