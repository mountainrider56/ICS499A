package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.darkweb.monitoring

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DarkwebMonitoringPersonalEmailAddressesSpec extends Specification {

    def 'defineService'() {
        setup:
        DarkwebMonitoringPersonalEmailAddresses darkwebMonitoringPersonalEmailAddresses = new DarkwebMonitoringPersonalEmailAddresses()

        when:
        Service service = darkwebMonitoringPersonalEmailAddresses.defineService()

        then:
        service // not null
        service.id == 'DarkwebMonitoringPersonalEmailAddressesADDITIONAL'
        service.price == 10
        service.title == 'Personal Email Addresses'
    }

}
