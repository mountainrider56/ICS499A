package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.network.device


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class NetworkDeviceSpec extends Specification {

    def 'defineService'() {
        setup:
        NetworkDevice networkDevice = new NetworkDevice()

        when:
        Service service = networkDevice.defineService()

        then:
        service // not null
        service.id == 'NetworkDeviceADDITIONAL'
        service.price == 0
        service.title == 'Network Device'
    }

}
