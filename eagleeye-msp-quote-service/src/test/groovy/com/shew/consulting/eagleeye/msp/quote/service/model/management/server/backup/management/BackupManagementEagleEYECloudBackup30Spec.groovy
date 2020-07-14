package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup30Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup30 backupManagementEagleEYECloudBackup30 = new BackupManagementEagleEYECloudBackup30()

        when:
        Service service = backupManagementEagleEYECloudBackup30.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup30SERVER'
        service.price == 39.95 as Double
        service.title == 'eagleEYE Cloud Backup (30GB)'
    }

}
