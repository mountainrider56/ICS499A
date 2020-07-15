package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.periodic.planning.review

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicPlanningReviewQuarterlySpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicPlanningReviewQuarterly periodicPlanningReviewQuarterly = new PeriodicPlanningReviewQuarterly()

        when:
        Service service = periodicPlanningReviewQuarterly.defineService()

        then:
        service // not null
        service.id == 'PeriodicPlanningReviewQuarterlyADDITIONAL'
        service.price == 40
        service.title == 'Quarterly'
    }

}
