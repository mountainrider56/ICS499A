package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.reporting;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class ReportingQuarterly implements ServiceDefinition {

    public static final String TITLE = "Quarterly";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 15);
    }

}
