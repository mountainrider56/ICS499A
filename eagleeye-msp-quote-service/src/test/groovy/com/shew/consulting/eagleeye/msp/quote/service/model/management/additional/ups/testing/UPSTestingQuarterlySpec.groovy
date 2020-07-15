package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.ups.testing

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class UPSTestingQuarterlySpec extends Specification {

    def 'defineService'() {
        setup:
        UPSTestingQuarterly upsTestingQuarterly = new UPSTestingQuarterly()

        when:
        Service service = upsTestingQuarterly.defineService()

        then:
        service // not null
        service.id == 'UPSTestingQuarterlyADDITIONAL'
        service.price == 40
        service.title == 'Quarterly'
    }

}
