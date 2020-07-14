package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup3000Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup3000 backupManagementEagleEYECloudBackup3000 = new BackupManagementEagleEYECloudBackup3000()

        when:
        Service service = backupManagementEagleEYECloudBackup3000.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup3000SERVER'
        service.price == 2250
        service.title == 'eagleEYE Cloud Backup (3000GB)'
    }

}
