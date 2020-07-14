package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementHardwareAssistedCloudBackup500Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementHardwareAssistedCloudBackup500 backupManagementHardwareAssistedCloudBackup500 = new BackupManagementHardwareAssistedCloudBackup500()

        when:
        Service service = backupManagementHardwareAssistedCloudBackup500.defineService()

        then:
        service // not null
        service.id == 'BackupManagementHardwareAssistedCloudBackup500SERVER'
        service.price == 199.99 as Double
        service.title == '500GB'
    }

}
