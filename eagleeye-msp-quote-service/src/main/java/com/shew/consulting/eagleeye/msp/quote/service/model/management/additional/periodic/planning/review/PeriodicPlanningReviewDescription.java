package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.periodic.planning.review;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Additional: Periodic Planning Review Service: Description
 */
@Component
public class PeriodicPlanningReviewDescription implements ServiceDefinition {

    public static final String TITLE =
            "Backup process review, Anti-virus strategy, hardware, asset and warranty review";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 0);
    }

}
