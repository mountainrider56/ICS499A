package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.asset.warranty.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class AssetWarrantyManagementHardwareInventorySpec extends Specification {

    def 'defineService'() {
        setup:
        AssetWarrantyManagementHardwareInventory assetWarrantyManagementHardwareInventory = new AssetWarrantyManagementHardwareInventory()

        when:
        Service service = assetWarrantyManagementHardwareInventory.defineService()

        then:
        service // not null
        service.id == 'AssetWarrantyManagementHardwareInventoryADDITIONAL'
        service.price == 0.5 as double
        service.title == 'Hardware Inventory'
    }

}
