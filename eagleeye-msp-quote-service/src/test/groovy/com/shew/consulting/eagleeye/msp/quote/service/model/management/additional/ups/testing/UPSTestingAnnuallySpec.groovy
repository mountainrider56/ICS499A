package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.ups.testing

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class UPSTestingAnnuallySpec extends Specification {

    def 'defineService'() {
        setup:
        UPSTestingAnnually upsTestingAnnually = new UPSTestingAnnually()

        when:
        Service service = upsTestingAnnually.defineService()

        then:
        service // not null
        service.id == 'UPSTestingAnnuallyADDITIONAL'
        service.price == 10
        service.title == 'Annually'
    }

}
