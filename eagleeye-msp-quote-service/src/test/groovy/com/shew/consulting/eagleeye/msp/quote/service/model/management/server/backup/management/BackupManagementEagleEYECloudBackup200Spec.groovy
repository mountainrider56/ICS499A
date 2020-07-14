package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup200Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup200 backupManagementEagleEYECloudBackup200 = new BackupManagementEagleEYECloudBackup200()

        when:
        Service service = backupManagementEagleEYECloudBackup200.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup200SERVER'
        service.price == 169.95 as Double
        service.title == 'eagleEYE Cloud Backup (200GB)'
    }

}
