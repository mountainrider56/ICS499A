package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.darkweb.monitoring

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DarkwebMonitoringDomainsSpec extends Specification {

    def 'defineService'() {
        setup:
        DarkwebMonitoringDomains darkwebMonitoringDomains = new DarkwebMonitoringDomains()

        when:
        Service service = darkwebMonitoringDomains.defineService()

        then:
        service // not null
        service.id == 'DarkwebMonitoringDomainsADDITIONAL'
        service.price == 100
        service.title == 'Domains'
    }

}
