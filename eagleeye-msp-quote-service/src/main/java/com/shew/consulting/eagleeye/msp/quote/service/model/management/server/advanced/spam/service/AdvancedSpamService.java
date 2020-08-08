package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.advanced.spam.service;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Server: Advanced Spam Service
 */
@Component
public class AdvancedSpamService implements ServiceDefinition {

    public static final String TITLE = "Advanced Spam Service";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 0);
    }

}
