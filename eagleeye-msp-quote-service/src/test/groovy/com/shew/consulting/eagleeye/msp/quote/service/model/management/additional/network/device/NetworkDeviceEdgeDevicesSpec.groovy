package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.network.device

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class NetworkDeviceEdgeDevicesSpec extends Specification {

    def 'defineService'() {
        setup:
        NetworkDeviceEdgeDevices networkDeviceEdgeDevices = new NetworkDeviceEdgeDevices()

        when:
        Service service = networkDeviceEdgeDevices.defineService()

        then:
        service // not null
        service.id == 'NetworkDeviceEdgeDevicesADDITIONAL'
        service.price == 10
        service.title == 'Edge Devices'
    }

}
