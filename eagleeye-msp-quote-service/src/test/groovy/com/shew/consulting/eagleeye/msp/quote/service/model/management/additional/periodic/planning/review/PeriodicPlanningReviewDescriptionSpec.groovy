package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.periodic.planning.review

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicPlanningReviewDescriptionSpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicPlanningReviewDescription periodicPlanningReviewDescription = new PeriodicPlanningReviewDescription()

        when:
        Service service = periodicPlanningReviewDescription.defineService()

        then:
        service // not null
        service.id == 'PeriodicPlanningReviewDescriptionADDITIONAL'
        service.price == 0
        service.title == 'Backup process review, Anti-virus strategy, hardware, asset and warranty review'
    }

}
