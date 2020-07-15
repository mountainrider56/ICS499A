package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.ups.testing


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class UPSTestingSpec extends Specification {

    def 'defineService'() {
        setup:
        UPSTesting upsTesting = new UPSTesting()

        when:
        Service service = upsTesting.defineService()

        then:
        service // not null
        service.id == 'UPSTestingADDITIONAL'
        service.price == 0
        service.title == 'UPS Testing (Onsite)'
    }

}
