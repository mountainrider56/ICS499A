package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BasicSpamServiceDomainLevelFilteringSpec extends Specification {

    def 'defineService'() {
        setup:
        BasicSpamServiceDomainLevelFiltering domainLevelFiltering = new BasicSpamServiceDomainLevelFiltering()

        when:
        Service service = domainLevelFiltering.defineService()

        then:
        service // not null
        service.id == 'BasicSpamServiceDomainLevelFilteringPC'
        service.price == 2.5
        service.title == 'Domain Level Filtering'
    }

}
