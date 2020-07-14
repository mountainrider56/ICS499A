package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.darkweb.monitoring;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class DarkwebMonitoringPersonalEmailAddresses implements ServiceDefinition {

    public static final String TITLE = "Personal Email Addresses";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 10);
    }

}
