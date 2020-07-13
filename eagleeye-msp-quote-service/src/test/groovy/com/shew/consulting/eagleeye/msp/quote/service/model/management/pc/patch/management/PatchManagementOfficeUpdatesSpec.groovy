package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PatchManagementOfficeUpdatesSpec extends Specification {

    def 'defineService'() {
        setup:
        PatchManagementOfficeUpdates officeUpdates = new PatchManagementOfficeUpdates()

        when:
        Service service = officeUpdates.defineService()

        then:
        service // not null
        service.id == 'PatchManagementOfficeUpdatesPC'
        service.price == 3
        service.title == 'Office Updates'
    }

}
