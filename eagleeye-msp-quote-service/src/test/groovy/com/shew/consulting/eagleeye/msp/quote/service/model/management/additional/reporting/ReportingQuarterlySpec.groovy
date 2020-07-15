package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.reporting

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class ReportingQuarterlySpec extends Specification {

    def 'defineService'() {
        setup:
        ReportingQuarterly reportingQuarterly = new ReportingQuarterly()

        when:
        Service service = reportingQuarterly.defineService()

        then:
        service // not null
        service.id == 'ReportingQuarterlyADDITIONAL'
        service.price == 15
        service.title == 'Quarterly'
    }

}
