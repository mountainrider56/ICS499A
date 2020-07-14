package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup2000Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup2000 backupManagementEagleEYECloudBackup2000 = new BackupManagementEagleEYECloudBackup2000()

        when:
        Service service = backupManagementEagleEYECloudBackup2000.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup2000SERVER'
        service.price == 1500
        service.title == 'eagleEYE Cloud Backup (2000GB)'
    }

}
