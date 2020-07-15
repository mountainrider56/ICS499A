package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.ups.testing

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class UPSTestingMonthlySpec extends Specification {

    def 'defineService'() {
        setup:
        UPSTestingMonthly upsTestingMonthly = new UPSTestingMonthly()

        when:
        Service service = upsTestingMonthly.defineService()

        then:
        service // not null
        service.id == 'UPSTestingMonthlyADDITIONAL'
        service.price == 120
        service.title == 'Monthly'
    }

}
