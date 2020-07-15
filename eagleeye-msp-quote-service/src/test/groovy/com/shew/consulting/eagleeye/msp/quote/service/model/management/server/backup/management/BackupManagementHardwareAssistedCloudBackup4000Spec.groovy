package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementHardwareAssistedCloudBackup4000Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementHardwareAssistedCloudBackup4000 backupManagementHardwareAssistedCloudBackup4000 = new BackupManagementHardwareAssistedCloudBackup4000()

        when:
        Service service = backupManagementHardwareAssistedCloudBackup4000.defineService()

        then:
        service // not null
        service.id == 'BackupManagementHardwareAssistedCloudBackup4000SERVER'
        service.price == 799.99 as double
        service.title == '4000GB'
    }

}
