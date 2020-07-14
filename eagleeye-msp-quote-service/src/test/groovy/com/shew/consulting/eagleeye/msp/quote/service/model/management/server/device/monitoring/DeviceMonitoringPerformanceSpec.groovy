package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.device.monitoring

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DeviceMonitoringPerformanceSpec extends Specification {

    def 'defineService'() {
        setup:
        DeviceMonitoringPerformance deviceMonitoringPerformance = new DeviceMonitoringPerformance()

        when:
        Service service = deviceMonitoringPerformance.defineService()

        then:
        service // not null
        service.id == 'DeviceMonitoringPerformanceSERVER'
        service.price == 0
        service.title == 'Performance'
    }

}
