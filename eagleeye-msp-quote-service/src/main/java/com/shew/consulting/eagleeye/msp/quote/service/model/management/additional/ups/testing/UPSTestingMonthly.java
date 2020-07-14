package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.ups.testing;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class UPSTestingMonthly implements ServiceDefinition {

    public static final String TITLE = "Monthly";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 120);
    }

}
