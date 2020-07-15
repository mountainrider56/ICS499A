package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.asset.warranty.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AssetWarrantyManagementWarrantyExpirationSpec extends Specification {

    def 'defineService'() {
        setup:
        AssetWarrantyManagementWarrantyExpiration assetWarrantyManagementWarrantyExpiration = new AssetWarrantyManagementWarrantyExpiration()

        when:
        Service service = assetWarrantyManagementWarrantyExpiration.defineService()

        then:
        service // not null
        service.id == 'AssetWarrantyManagementWarrantyExpirationADDITIONAL'
        service.price == 0.5 as Double
        service.title == 'Warranty Expiration'
    }

}
