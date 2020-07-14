package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.anti.virus.anti.spyware.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntiVirusAntiSpywareDetectionApplicationUpdatesSpec extends Specification {

    def 'defineService'() {
        setup:
        AntiVirusAntiSpywareDetectionApplicationUpdates antiVirusAntiSpywareDetectionApplicationUpdates = new AntiVirusAntiSpywareDetectionApplicationUpdates()

        when:
        Service service = antiVirusAntiSpywareDetectionApplicationUpdates.defineService()

        then:
        service // not null
        service.id == 'AntiVirusAntiSpywareDetectionApplicationUpdatesSERVER'
        service.price == 0
        service.title == 'Application Updates'
    }

}
