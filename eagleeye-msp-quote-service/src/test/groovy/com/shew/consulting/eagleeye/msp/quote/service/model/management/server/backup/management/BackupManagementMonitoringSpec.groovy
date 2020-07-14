package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementMonitoringSpec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementMonitoring backupManagementMonitoring = new BackupManagementMonitoring()

        when:
        Service service = backupManagementMonitoring.defineService()

        then:
        service // not null
        service.id == 'BackupManagementMonitoringSERVER'
        service.price == 30
        service.title == 'Monitoring'
    }

}
