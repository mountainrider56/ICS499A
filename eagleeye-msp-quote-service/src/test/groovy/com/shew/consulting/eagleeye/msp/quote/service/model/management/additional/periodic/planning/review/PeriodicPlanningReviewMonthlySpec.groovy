package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.periodic.planning.review

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicPlanningReviewMonthlySpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicPlanningReviewMonthly periodicPlanningReviewMonthly = new PeriodicPlanningReviewMonthly()

        when:
        Service service = periodicPlanningReviewMonthly.defineService()

        then:
        service // not null
        service.id == 'PeriodicPlanningReviewMonthlyADDITIONAL'
        service.price == 120
        service.title == 'Monthly'
    }

}
