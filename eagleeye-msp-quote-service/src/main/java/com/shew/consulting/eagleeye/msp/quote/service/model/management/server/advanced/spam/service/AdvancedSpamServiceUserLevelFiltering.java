package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.advanced.spam.service;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Server: Advanced Spam Service: User Level Filtering
 */
@Component
public class AdvancedSpamServiceUserLevelFiltering implements ServiceDefinition {

    public static final String TITLE = "User Level Filtering";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 2.75);
    }

}
