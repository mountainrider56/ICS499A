package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class HelpDeskSpec extends Specification {

    def 'defineService'() {
        setup:
        HelpDesk helpDesk = new HelpDesk()

        when:
        Service service = helpDesk.defineService()

        then:
        service // not null
        service.id == 'HelpDeskPC'
        service.price == 20
        service.title == 'Help Desk (24x7)'
    }

}
