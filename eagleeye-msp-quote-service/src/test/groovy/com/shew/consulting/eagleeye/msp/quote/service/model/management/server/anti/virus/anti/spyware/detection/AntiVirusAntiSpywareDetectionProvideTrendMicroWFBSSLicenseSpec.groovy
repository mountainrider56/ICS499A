package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.anti.virus.anti.spyware.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntiVirusAntiSpywareDetectionProvideTrendMicroWFBSSLicenseSpec extends Specification {

    def 'defineService'() {
        setup:
        AntiVirusAntiSpywareDetectionProvideTrendMicroWFBSSLicense antiVirusAntiSpywareDetectionProvideTrendMicroWFBSSLicense = new AntiVirusAntiSpywareDetectionProvideTrendMicroWFBSSLicense()

        when:
        Service service = antiVirusAntiSpywareDetectionProvideTrendMicroWFBSSLicense.defineService()

        then:
        service // not null
        service.id == 'AntiVirusAntiSpywareDetectionProvideTrendMicroWFBSSLicenseSERVER'
        service.price == 0
        service.title == 'Provide Trend Micro WFBSS License'
    }

}
