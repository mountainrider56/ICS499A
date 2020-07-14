package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup1000Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup1000 backupManagementEagleEYECloudBackup1000 = new BackupManagementEagleEYECloudBackup1000()

        when:
        Service service = backupManagementEagleEYECloudBackup1000.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup1000SERVER'
        service.price == 750
        service.title == 'eagleEYE Cloud Backup (1000GB)'
    }

}
