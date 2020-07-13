package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntivirusDetectionScheduledScanningSpec extends Specification {

    def 'defineService'() {
        setup:
        AntivirusDetectionScheduledScanning scheduledScanning = new AntivirusDetectionScheduledScanning()

        when:
        Service service = scheduledScanning.defineService()

        then:
        service // not null
        service.id == 'AntivirusDetectionScheduledScanningPC'
        service.price == 0
        service.title == 'Scheduled Scanning'
    }

}
