package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AntivirusDetectionProvideTrendMicroWFBSSLicenseSpec extends Specification {

    def 'defineService'() {
        setup:
        AntivirusDetectionProvideTrendMicroWFBSSLicense provideTrendMicroWFBSSLicense = new AntivirusDetectionProvideTrendMicroWFBSSLicense()

        when:
        Service service = provideTrendMicroWFBSSLicense.defineService()

        then:
        service // not null
        service.id == 'AntivirusDetectionProvideTrendMicroWFBSSLicensePC'
        service.price == 0
        service.title == 'Provide Trend Micro WFBSS License'
    }

}
