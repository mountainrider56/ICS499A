package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.device.monitoring

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class DeviceMonitoringSystemLogsSpec extends Specification {

    def 'defineService'() {
        setup:
        DeviceMonitoringSystemLogs deviceMonitoringSystemLogs = new DeviceMonitoringSystemLogs()

        when:
        Service service = deviceMonitoringSystemLogs.defineService()

        then:
        service // not null
        service.id == 'DeviceMonitoringSystemLogsSERVER'
        service.price == 0
        service.title == 'System Logs'
    }

}
