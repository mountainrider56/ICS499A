package com.shew.consulting.eagleeye.msp.quote.service.data;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import com.shew.consulting.eagleeye.msp.quote.service.repository.BusinessServiceRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PopulateBusinessServiceRepository {

    private final BusinessServiceRespository businessServiceRespository;
    private final ApplicationContext applicationContext;

    @EventListener
    public void applicationReady(ApplicationReadyEvent event) {
        System.out.println(event);
        Map<String, BusinessService> beans = applicationContext.getBeansOfType(BusinessService.class);
        businessServiceRespository.saveAll(beans.values());
    }

}
