package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.network.device

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class NetworkDeviceSNMPDevicesSpec extends Specification {

    def 'defineService'() {
        setup:
        NetworkDeviceSNMPDevices networkDeviceSNMPDevices = new NetworkDeviceSNMPDevices()

        when:
        Service service = networkDeviceSNMPDevices.defineService()

        then:
        service // not null
        service.id == 'NetworkDeviceSNMPDevicesADDITIONAL'
        service.price == 10
        service.title == 'SNMP Devices'
    }

}
