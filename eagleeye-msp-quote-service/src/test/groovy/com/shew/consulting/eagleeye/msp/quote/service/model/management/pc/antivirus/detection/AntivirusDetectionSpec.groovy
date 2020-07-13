package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntivirusDetectionSpec extends Specification {

    def 'defineService'() {
        setup:
        AntivirusDetection antivirusDetection = new AntivirusDetection()

        when:
        Service service = antivirusDetection.defineService()

        then:
        service // not null
        service.id == 'AntivirusDetectionPC'
        service.price == 3.25
        service.title == 'AntiVirus Detection'
    }

}
