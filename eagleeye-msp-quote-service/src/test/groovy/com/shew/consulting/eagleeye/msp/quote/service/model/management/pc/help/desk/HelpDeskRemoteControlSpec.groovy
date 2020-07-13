package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class HelpDeskRemoteControlSpec extends Specification {

    def 'defineService'() {
        setup:
        HelpDeskRemoteControl remoteControl = new HelpDeskRemoteControl()

        when:
        Service service = remoteControl.defineService()

        then:
        service // not null
        service.id == 'HelpDeskRemoteControlPC'
        service.price == 0
        service.title == 'Remote Control'
    }

}
