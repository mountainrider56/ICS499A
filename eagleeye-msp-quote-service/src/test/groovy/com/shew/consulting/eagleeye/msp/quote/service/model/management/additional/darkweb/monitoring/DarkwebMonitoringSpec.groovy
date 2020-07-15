package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.darkweb.monitoring


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DarkwebMonitoringSpec extends Specification {

    def 'defineService'() {
        setup:
        DarkwebMonitoring darkwebMonitoring = new DarkwebMonitoring()

        when:
        Service service = darkwebMonitoring.defineService()

        then:
        service // not null
        service.id == 'DarkwebMonitoringADDITIONAL'
        service.price == 0
        service.title == 'Darkweb Monitoring'
    }

}
