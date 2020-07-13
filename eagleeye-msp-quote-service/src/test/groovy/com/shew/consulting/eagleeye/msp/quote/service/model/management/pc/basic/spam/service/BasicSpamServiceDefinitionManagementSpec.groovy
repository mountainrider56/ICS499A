package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BasicSpamServiceDefinitionManagementSpec extends Specification {

    def 'defineService'() {
        setup:
        BasicSpamServiceDefinitionManagement definitionManagement = new BasicSpamServiceDefinitionManagement()

        when:
        Service service = definitionManagement.defineService()

        then:
        service // not null
        service.id == 'BasicSpamServiceDefinitionManagementPC'
        service.price == 0
        service.title == 'Definition Management'
    }

}
