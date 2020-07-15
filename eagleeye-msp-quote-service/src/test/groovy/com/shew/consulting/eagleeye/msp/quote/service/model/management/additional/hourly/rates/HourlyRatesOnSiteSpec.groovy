package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.hourly.rates

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class HourlyRatesOnSiteSpec extends Specification {

    def 'defineService'() {
        setup:
        HourlyRatesOnSite hourlyRatesOnSite = new HourlyRatesOnSite()

        when:
        Service service = hourlyRatesOnSite.defineService()

        then:
        service // not null
        service.id == 'HourlyRatesOnSiteADDITIONAL'
        service.price == 120
        service.title == 'On-site'
    }

}
