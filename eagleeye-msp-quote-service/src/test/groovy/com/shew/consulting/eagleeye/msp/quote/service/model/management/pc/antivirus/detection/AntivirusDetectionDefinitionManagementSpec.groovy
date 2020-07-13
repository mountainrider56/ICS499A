package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntivirusDetectionDefinitionManagementSpec extends Specification {

    def 'defineService'() {
        setup:
        AntivirusDetectionDefinitionManagement definitionManagement = new AntivirusDetectionDefinitionManagement()

        when:
        Service service = definitionManagement.defineService()

        then:
        service // not null
        service.id == 'AntivirusDetectionDefinitionManagementPC'
        service.price == 0
        service.title == 'Definition Management'
    }

}
