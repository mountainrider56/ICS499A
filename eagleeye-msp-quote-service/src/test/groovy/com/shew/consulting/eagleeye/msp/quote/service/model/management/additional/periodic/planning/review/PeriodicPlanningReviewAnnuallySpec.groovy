package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.periodic.planning.review

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicPlanningReviewAnnuallySpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicPlanningReviewAnnually periodicPlanningReviewAnnually = new PeriodicPlanningReviewAnnually()

        when:
        Service service = periodicPlanningReviewAnnually.defineService()

        then:
        service // not null
        service.id == 'PeriodicPlanningReviewAnnuallyADDITIONAL'
        service.price == 10
        service.title == 'Annually'
    }

}
