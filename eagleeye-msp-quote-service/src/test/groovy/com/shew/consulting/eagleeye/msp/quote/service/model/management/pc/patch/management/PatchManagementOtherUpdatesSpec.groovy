package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PatchManagementOtherUpdatesSpec extends Specification {

    def 'defineService'() {
        setup:
        PatchManagementOtherUpdates otherUpdates = new PatchManagementOtherUpdates()

        when:
        Service service = otherUpdates.defineService()

        then:
        service // not null
        service.id == 'PatchManagementOtherUpdatesPC'
        service.price == 3
        service.title == 'Other Updates - AVG, Trend Micro'
    }

}
