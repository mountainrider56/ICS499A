package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PatchManagementWindowsUpdatesSpec extends Specification {

    def 'defineService'() {
        setup:
        PatchManagementWindowsUpdates windowsUpdates = new PatchManagementWindowsUpdates()

        when:
        Service service = windowsUpdates.defineService()

        then:
        service // not null
        service.id == 'PatchManagementWindowsUpdatesPC'
        service.price == 12
        service.title == 'Windows Updates'
    }

}
