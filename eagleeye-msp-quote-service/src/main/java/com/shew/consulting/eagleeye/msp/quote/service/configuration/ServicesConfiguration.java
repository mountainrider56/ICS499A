package com.shew.consulting.eagleeye.msp.quote.service.configuration;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration for the list of quote services.
 */
@Configuration
@RequiredArgsConstructor
public class ServicesConfiguration {

    private final ApplicationContext applicationContext;

    @Bean
    public Map<String, Service> services() {
        Map<String, Service> services = new HashMap<>();
        applicationContext.getBeansOfType(ServiceDefinition.class)
                          .values()
                          .forEach(i -> {
                              Service service = i.defineService();
                              services.put(service.getId(), service);
                          });
        return services;
    }

}
