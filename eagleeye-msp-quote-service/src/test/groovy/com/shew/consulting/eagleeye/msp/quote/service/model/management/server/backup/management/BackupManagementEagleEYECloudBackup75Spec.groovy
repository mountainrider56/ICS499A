package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup75Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup75 backupManagementEagleEYECloudBackup75 = new BackupManagementEagleEYECloudBackup75()

        when:
        Service service = backupManagementEagleEYECloudBackup75.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup75SERVER'
        service.price == 79.95 as double
        service.title == 'eagleEYE Cloud Backup (75GB)'
    }

}
