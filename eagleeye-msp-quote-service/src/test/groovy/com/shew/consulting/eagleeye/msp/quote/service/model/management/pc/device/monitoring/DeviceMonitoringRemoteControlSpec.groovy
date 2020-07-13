package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DeviceMonitoringRemoteControlSpec extends Specification {

    def 'defineService'() {
        setup:
        DeviceMonitoringRemoteControl remoteControl = new DeviceMonitoringRemoteControl()

        when:
        Service service = remoteControl.defineService()

        then:
        service // not null
        service.id == 'DeviceMonitoringRemoteControlPC'
        service.price == 0
        service.title == 'Remote Control'
    }

}
