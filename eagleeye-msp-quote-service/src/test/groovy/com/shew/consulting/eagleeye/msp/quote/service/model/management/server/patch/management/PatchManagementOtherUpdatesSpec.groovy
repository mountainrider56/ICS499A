package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.patch.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PatchManagementOtherUpdatesSpec extends Specification {

    def 'defineService'() {
        setup:
        PatchManagementOtherUpdates patchManagementOtherUpdates = new PatchManagementOtherUpdates()

        when:
        Service service = patchManagementOtherUpdates.defineService()

        then:
        service // not null
        service.id == 'PatchManagementOtherUpdatesSERVER'
        service.price == 30
        service.title == 'Other Updates - AVG, Trend Micro'
    }

}
