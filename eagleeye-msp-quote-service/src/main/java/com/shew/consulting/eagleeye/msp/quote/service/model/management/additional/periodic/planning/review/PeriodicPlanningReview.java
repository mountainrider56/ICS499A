package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.periodic.planning.review;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Additional: Periodic Planning Review Service
 */
@Component
public class PeriodicPlanningReview implements ServiceDefinition {

    public static final String TITLE = "Periodic Planning and Review (Onsite)";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 0);
    }

}
