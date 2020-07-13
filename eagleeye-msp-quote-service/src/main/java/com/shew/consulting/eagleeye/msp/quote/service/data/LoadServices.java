package com.shew.consulting.eagleeye.msp.quote.service.data;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import com.shew.consulting.eagleeye.msp.quote.service.repository.ServiceRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

@Order(1)
@Component
@RequiredArgsConstructor
public class LoadServices {

    private final ServiceRespository serviceRespository;
    private final ApplicationContext applicationContext;

    @EventListener
    public void applicationReady(ApplicationReadyEvent event) {
        System.out.println(event);
        Map<String, ServiceDefinition> beans = applicationContext.getBeansOfType(ServiceDefinition.class);
        beans.values().parallelStream().forEach(i -> serviceRespository.save(i.defineService()));
    }

}
