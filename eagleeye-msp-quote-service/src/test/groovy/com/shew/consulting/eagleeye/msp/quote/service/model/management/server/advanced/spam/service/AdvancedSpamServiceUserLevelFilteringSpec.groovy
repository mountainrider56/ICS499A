package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.advanced.spam.service

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AdvancedSpamServiceUserLevelFilteringSpec extends Specification {

    def 'defineService'() {
        setup:
        AdvancedSpamServiceUserLevelFiltering advancedSpamServiceUserLevelFiltering = new AdvancedSpamServiceUserLevelFiltering()

        when:
        Service service = advancedSpamServiceUserLevelFiltering.defineService()

        then:
        service // not null
        service.id == 'AdvancedSpamServiceUserLevelFilteringSERVER'
        service.price == 2.75 as Double
        service.title == 'User Level Filtering'
    }

}
