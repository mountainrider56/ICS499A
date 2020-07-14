package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.patch.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PatchManagementOfficeUpdatesSpec extends Specification {

    def 'defineService'() {
        setup:
        PatchManagementOfficeUpdates patchManagementOfficeUpdates = new PatchManagementOfficeUpdates()

        when:
        Service service = patchManagementOfficeUpdates.defineService()

        then:
        service // not null
        service.id == 'PatchManagementOfficeUpdatesSERVER'
        service.price == 30
        service.title == 'Office Updates'
    }

}
