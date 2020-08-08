package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: Basic Spam Service
 */
@Component
public class BasicSpamService implements ServiceDefinition {

    public static final String TITLE = "Basic Spam Service";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 0);
    }

}
