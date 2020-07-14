package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.anti.virus.anti.spyware.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntiVirusAntiSpywareDetectionSpec extends Specification {

    def 'defineService'() {
        setup:
        AntiVirusAntiSpywareDetection antiVirusAntiSpywareDetection = new AntiVirusAntiSpywareDetection()

        when:
        Service service = antiVirusAntiSpywareDetection.defineService()

        then:
        service // not null
        service.id == 'AntiVirusAntiSpywareDetectionSERVER'
        service.price == 3.25 as Double
        service.title == 'AntiVirus/Antispyware Detection'
    }

}
