package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.hourly.rates


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class HourlyRatesSpec extends Specification {

    def 'defineService'() {
        setup:
        HourlyRates hourlyRates = new HourlyRates()

        when:
        Service service = hourlyRates.defineService()

        then:
        service // not null
        service.id == 'HourlyRatesADDITIONAL'
        service.price == 0
        service.title == 'Hourly Rates'
    }

}
