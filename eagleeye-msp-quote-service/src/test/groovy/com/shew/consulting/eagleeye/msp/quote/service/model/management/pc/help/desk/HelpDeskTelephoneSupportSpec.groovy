package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class HelpDeskTelephoneSupportSpec extends Specification {

    def 'defineService'() {
        setup:
        HelpDeskTelephoneSupport telephoneSupport = new HelpDeskTelephoneSupport()

        when:
        Service service = telephoneSupport.defineService()

        then:
        service // not null
        service.id == 'HelpDeskTelephoneSupportPC'
        service.price == 0
        service.title == 'Telephone Support'
    }

}
