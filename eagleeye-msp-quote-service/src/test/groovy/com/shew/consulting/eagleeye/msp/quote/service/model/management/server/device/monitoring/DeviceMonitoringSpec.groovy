package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.device.monitoring


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DeviceMonitoringSpec extends Specification {

    def 'defineService'() {
        setup:
        DeviceMonitoring deviceMonitoring = new DeviceMonitoring()

        when:
        Service service = deviceMonitoring.defineService()

        then:
        service // not null
        service.id == 'DeviceMonitoringSERVER'
        service.price == 40
        service.title == 'Device Monitoring'
    }

}
