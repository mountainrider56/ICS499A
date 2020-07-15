package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.reporting

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class ReportingMonthlySpec extends Specification {

    def 'defineService'() {
        setup:
        ReportingMonthly reportingMonthly = new ReportingMonthly()

        when:
        Service service = reportingMonthly.defineService()

        then:
        service // not null
        service.id == 'ReportingMonthlyADDITIONAL'
        service.price == 60
        service.title == 'Monthly'
    }

}
