package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.hourly.rates;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Additional: Hourly Rates: Remote support
 */
@Component
public class HourlyRatesRemoteSupport implements ServiceDefinition {

    public static final String TITLE = "Remote Support";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 110);
    }

}
