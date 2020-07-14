package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementHardwareAssistedCloudBackupSpec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementHardwareAssistedCloudBackup backupManagementHardwareAssistedCloudBackup =
                new BackupManagementHardwareAssistedCloudBackup()

        when:
        Service service = backupManagementHardwareAssistedCloudBackup.defineService()

        then:
        service // not null
        service.id == 'BackupManagementHardwareAssistedCloudBackupSERVER'
        service.price == 0
        service.title == 'Hardware Assisted Cloud Backup (Barracuda via eagleEYE)'
    }

}
