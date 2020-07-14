package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.help.desk

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class HelpDeskTelephoneSupportSpec extends Specification {

    def 'defineService'() {
        setup:
        HelpDeskTelephoneSupport helpDeskTelephoneSupport = new HelpDeskTelephoneSupport()

        when:
        Service service = helpDeskTelephoneSupport.defineService()

        then:
        service // not null
        service.id == 'HelpDeskTelephoneSupportSERVER'
        service.price == 0
        service.title == 'Telephone Support'
    }

}
