package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup250Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup250 backupManagementEagleEYECloudBackup250 = new BackupManagementEagleEYECloudBackup250()

        when:
        Service service = backupManagementEagleEYECloudBackup250.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup250SERVER'
        service.price == 199.95 as double
        service.title == 'eagleEYE Cloud Backup (250GB)'
    }

}
