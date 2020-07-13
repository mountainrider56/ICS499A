package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DeviceMonitoringPerformanceSpec extends Specification {

    def 'defineService'() {
        setup:
        DeviceMonitoringPerformance performance = new DeviceMonitoringPerformance()

        when:
        Service service = performance.defineService()

        then:
        service // not null
        service.id == 'DeviceMonitoringPerformancePC'
        service.price == 0
        service.title == 'Performance'
    }

}
