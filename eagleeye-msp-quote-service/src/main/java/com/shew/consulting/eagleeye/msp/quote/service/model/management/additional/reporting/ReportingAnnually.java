package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.reporting;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Additional: Reporting Service: Annually
 */
@Component
public class ReportingAnnually implements ServiceDefinition {

    public static final String TITLE = "Annually";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 5);
    }

}
