package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BasicSpamServiceSpec extends Specification {

    def 'defineService'() {
        setup:
        BasicSpamService basicSpamService = new BasicSpamService()

        when:
        Service service = basicSpamService.defineService()

        then:
        service // not null
        service.id == 'BasicSpamServicePC'
        service.price == 0
        service.title == 'Basic Spam Service'
    }

}
