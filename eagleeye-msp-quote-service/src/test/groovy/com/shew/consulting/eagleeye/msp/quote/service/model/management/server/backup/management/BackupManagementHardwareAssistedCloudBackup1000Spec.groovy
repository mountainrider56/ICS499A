package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementHardwareAssistedCloudBackup1000Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementHardwareAssistedCloudBackup1000 backupManagementHardwareAssistedCloudBackup1000 = new BackupManagementHardwareAssistedCloudBackup1000()

        when:
        Service service = backupManagementHardwareAssistedCloudBackup1000.defineService()

        then:
        service // not null
        service.id == 'BackupManagementHardwareAssistedCloudBackup1000SERVER'
        service.price == 299.99 as double
        service.title == '1000GB'
    }

}
