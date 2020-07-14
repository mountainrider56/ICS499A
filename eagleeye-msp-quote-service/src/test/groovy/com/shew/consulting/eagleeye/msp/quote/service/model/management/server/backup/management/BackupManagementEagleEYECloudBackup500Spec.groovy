package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup500Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup500 backupManagementEagleEYECloudBackup500 = new BackupManagementEagleEYECloudBackup500()

        when:
        Service service = backupManagementEagleEYECloudBackup500.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup500SERVER'
        service.price == 375
        service.title == 'eagleEYE Cloud Backup (500GB)'
    }

}
