package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.asset.warranty.management


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AssetWarrantyManagementSpec extends Specification {

    def 'defineService'() {
        setup:
        AssetWarrantyManagement assetWarrantyManagement = new AssetWarrantyManagement()

        when:
        Service service = assetWarrantyManagement.defineService()

        then:
        service // not null
        service.id == 'AssetWarrantyManagementADDITIONAL'
        service.price == 0
        service.title == 'Asset/Warranty Management'
    }

}
