package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.patch.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PatchManagementWindowsUpdatesSpec extends Specification {

    def 'defineService'() {
        setup:
        PatchManagementWindowsUpdates patchManagementWindowsUpdates = new PatchManagementWindowsUpdates()

        when:
        Service service = patchManagementWindowsUpdates.defineService()

        then:
        service // not null
        service.id == 'PatchManagementWindowsUpdatesSERVER'
        service.price == 55
        service.title == 'Windows Updates'
    }

}
