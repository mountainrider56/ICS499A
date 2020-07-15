package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.periodic.planning.review


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicPlanningReviewSpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicPlanningReview periodicPlanningReview = new PeriodicPlanningReview()

        when:
        Service service = periodicPlanningReview.defineService()

        then:
        service // not null
        service.id == 'PeriodicPlanningReviewADDITIONAL'
        service.price == 0
        service.title == 'Periodic Planning and Review (Onsite)'
    }

}
