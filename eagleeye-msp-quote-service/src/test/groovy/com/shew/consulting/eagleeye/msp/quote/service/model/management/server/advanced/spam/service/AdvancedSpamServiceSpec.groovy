package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.advanced.spam.service


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AdvancedSpamServiceSpec extends Specification {

    def 'defineService'() {
        setup:
        AdvancedSpamService advancedSpamService = new AdvancedSpamService()

        when:
        Service service = advancedSpamService.defineService()

        then:
        service // not null
        service.id == 'AdvancedSpamServiceSERVER'
        service.price == 0
        service.title == 'Advanced Spam Service'
    }

}
