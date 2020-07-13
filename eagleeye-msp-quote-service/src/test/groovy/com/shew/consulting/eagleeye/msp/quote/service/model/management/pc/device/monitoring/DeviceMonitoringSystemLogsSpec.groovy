package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DeviceMonitoringSystemLogsSpec extends Specification {

    def 'defineService'() {
        setup:
        DeviceMonitoringSystemLogs systemLogs = new DeviceMonitoringSystemLogs()

        when:
        Service service = systemLogs.defineService()

        then:
        service // not null
        service.id == 'DeviceMonitoringSystemLogsPC'
        service.price == 0
        service.title == 'System Logs'
    }

}
