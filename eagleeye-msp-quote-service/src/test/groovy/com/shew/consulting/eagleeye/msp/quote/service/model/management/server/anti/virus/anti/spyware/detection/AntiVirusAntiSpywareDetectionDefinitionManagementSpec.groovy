package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.anti.virus.anti.spyware.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntiVirusAntiSpywareDetectionDefinitionManagementSpec extends Specification {

    def 'defineService'() {
        setup:
        AntiVirusAntiSpywareDetectionDefinitionManagement antiVirusAntiSpywareDetectionDefinitionManagement = new AntiVirusAntiSpywareDetectionDefinitionManagement()

        when:
        Service service = antiVirusAntiSpywareDetectionDefinitionManagement.defineService()

        then:
        service // not null
        service.id == 'AntiVirusAntiSpywareDetectionDefinitionManagementSERVER'
        service.price == 0
        service.title == 'Definition Management'
    }

}
