package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup100Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup100 backupManagementEagleEYECloudBackup100 = new BackupManagementEagleEYECloudBackup100()

        when:
        Service service = backupManagementEagleEYECloudBackup100.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup100SERVER'
        service.price == 99.95 as double
        service.title == 'eagleEYE Cloud Backup (100GB)'
    }

}
