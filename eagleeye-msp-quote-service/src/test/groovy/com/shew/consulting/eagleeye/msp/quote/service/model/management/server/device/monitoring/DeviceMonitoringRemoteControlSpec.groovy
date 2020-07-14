package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.device.monitoring

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DeviceMonitoringRemoteControlSpec extends Specification {

    def 'defineService'() {
        setup:
        DeviceMonitoringRemoteControl deviceMonitoringRemoteControl = new DeviceMonitoringRemoteControl()

        when:
        Service service = deviceMonitoringRemoteControl.defineService()

        then:
        service // not null
        service.id == 'DeviceMonitoringRemoteControlSERVER'
        service.price == 0
        service.title == 'Remote Control'
    }

}
