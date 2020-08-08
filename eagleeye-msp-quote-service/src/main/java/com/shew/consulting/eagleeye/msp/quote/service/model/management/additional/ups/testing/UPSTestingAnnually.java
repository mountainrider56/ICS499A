package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.ups.testing;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Additional: UPS Testing Service: Annually
 */
@Component
public class UPSTestingAnnually implements ServiceDefinition {

    public static final String TITLE = "Annually";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 10);
    }

}
