package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup50Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup50 backupManagementEagleEYECloudBackup50 = new BackupManagementEagleEYECloudBackup50()

        when:
        Service service = backupManagementEagleEYECloudBackup50.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup50SERVER'
        service.price == 59.95 as Double
        service.title == 'eagleEYE Cloud Backup (50GB)'
    }

}
