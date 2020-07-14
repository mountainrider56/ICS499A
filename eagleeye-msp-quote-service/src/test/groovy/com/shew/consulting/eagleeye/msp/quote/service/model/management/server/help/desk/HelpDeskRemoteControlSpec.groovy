package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.help.desk

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class HelpDeskRemoteControlSpec extends Specification {

    def 'defineService'() {
        setup:
        HelpDeskRemoteControl helpDeskRemoteControl = new HelpDeskRemoteControl()

        when:
        Service service = helpDeskRemoteControl.defineService()

        then:
        service // not null
        service.id == 'HelpDeskRemoteControlSERVER'
        service.price == 0
        service.title == 'Remote Control'
    }

}
