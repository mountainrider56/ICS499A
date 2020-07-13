package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class BasicSpamServiceDomainLevelFiltering implements ServiceDefinition {

    public static final String TITLE = "Domain Level Filtering";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 2.50);
    }

}
