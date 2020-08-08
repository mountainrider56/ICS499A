package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.darkweb.monitoring;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Additional: Darkweb Monitoring Service
 */
@Component
public class DarkwebMonitoring implements ServiceDefinition {

    public static final String TITLE = "Darkweb Monitoring";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 0);
    }

}
