package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.anti.virus.anti.spyware.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntiVirusAntiSpywareDetectionHistoricReportsSpec extends Specification {

    def 'defineService'() {
        setup:
        AntiVirusAntiSpywareDetectionHistoricReports antiVirusAntiSpywareDetectionHistoricReports = new AntiVirusAntiSpywareDetectionHistoricReports()

        when:
        Service service = antiVirusAntiSpywareDetectionHistoricReports.defineService()

        then:
        service // not null
        service.id == 'AntiVirusAntiSpywareDetectionHistoricReportsSERVER'
        service.price == 0
        service.title == 'Historic Reports'
    }

}
