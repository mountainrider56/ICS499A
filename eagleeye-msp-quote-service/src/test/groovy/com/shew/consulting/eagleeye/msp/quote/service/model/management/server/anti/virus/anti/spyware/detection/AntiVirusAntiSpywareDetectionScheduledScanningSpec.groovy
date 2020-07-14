package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.anti.virus.anti.spyware.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntiVirusAntiSpywareDetectionScheduledScanningSpec extends Specification {

    def 'defineService'() {
        setup:
        AntiVirusAntiSpywareDetectionScheduledScanning antiSpywareDetectionScheduledScanning = new AntiVirusAntiSpywareDetectionScheduledScanning()

        when:
        Service service = antiSpywareDetectionScheduledScanning.defineService()

        then:
        service // not null
        service.id == 'AntiVirusAntiSpywareDetectionScheduledScanningSERVER'
        service.price == 0
        service.title == 'Scheduled Scanning'
    }

}
