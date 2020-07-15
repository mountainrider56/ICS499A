package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.reporting


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class ReportingSpec extends Specification {

    def 'defineService'() {
        setup:
        Reporting reporting = new Reporting()

        when:
        Service service = reporting.defineService()

        then:
        service // not null
        service.id == 'ReportingADDITIONAL'
        service.price == 0
        service.title == 'Reporting'
    }

}
