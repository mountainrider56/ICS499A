package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementHardwareAssistedCloudBackup2000Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementHardwareAssistedCloudBackup2000 backupManagementHardwareAssistedCloudBackup2000 = new BackupManagementHardwareAssistedCloudBackup2000()

        when:
        Service service = backupManagementHardwareAssistedCloudBackup2000.defineService()

        then:
        service // not null
        service.id == 'BackupManagementHardwareAssistedCloudBackup2000SERVER'
        service.price == 499.99 as Double
        service.title == '2000GB'
    }

}
