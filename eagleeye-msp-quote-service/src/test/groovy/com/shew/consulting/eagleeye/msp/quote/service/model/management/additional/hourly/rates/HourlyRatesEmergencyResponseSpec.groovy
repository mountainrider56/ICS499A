package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.hourly.rates

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class HourlyRatesEmergencyResponseSpec extends Specification {

    def 'defineService'() {
        setup:
        HourlyRatesEmergencyResponse hourlyRatesEmergencyResponse = new HourlyRatesEmergencyResponse()

        when:
        Service service = hourlyRatesEmergencyResponse.defineService()

        then:
        service // not null
        service.id == 'HourlyRatesEmergencyResponseADDITIONAL'
        service.price == 180
        service.title == 'Emergency Response'
    }

}
