package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntivirusDetectionHistoricReportsSpec extends Specification {

    def 'defineService'() {
        setup:
        AntivirusDetectionHistoricReports historicReports = new AntivirusDetectionHistoricReports()

        when:
        Service service = historicReports.defineService()

        then:
        service // not null
        service.id == 'AntivirusDetectionHistoricReportsPC'
        service.price == 0
        service.title == 'Historic Reports'
    }

}
