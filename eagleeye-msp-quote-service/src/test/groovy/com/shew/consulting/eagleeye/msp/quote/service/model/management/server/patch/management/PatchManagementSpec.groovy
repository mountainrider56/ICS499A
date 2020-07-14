package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.patch.management


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PatchManagementSpec extends Specification {

    def 'defineService'() {
        setup:
        PatchManagement patchManagement = new PatchManagement()

        when:
        Service service = patchManagement.defineService()

        then:
        service // not null
        service.id == 'PatchManagementSERVER'
        service.price == 0
        service.title == 'Patch Management'
    }

}
