package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.reporting

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class ReportingAnnuallySpec extends Specification {

    def 'defineService'() {
        setup:
        ReportingAnnually reportingAnnually = new ReportingAnnually()

        when:
        Service service = reportingAnnually.defineService()

        then:
        service // not null
        service.id == 'ReportingAnnuallyADDITIONAL'
        service.price == 5
        service.title == 'Annually'
    }

}
