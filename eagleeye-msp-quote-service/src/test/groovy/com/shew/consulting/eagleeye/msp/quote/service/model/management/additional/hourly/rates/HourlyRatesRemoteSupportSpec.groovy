package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.hourly.rates

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class HourlyRatesRemoteSupportSpec extends Specification {

    def 'defineService'() {
        setup:
        HourlyRatesRemoteSupport hourlyRatesRemoteSupport = new HourlyRatesRemoteSupport()

        when:
        Service service = hourlyRatesRemoteSupport.defineService()

        then:
        service // not null
        service.id == 'HourlyRatesRemoteSupportADDITIONAL'
        service.price == 110
        service.title == 'Remote Support'
    }

}
