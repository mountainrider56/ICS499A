package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup150Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup150 backupManagementEagleEYECloudBackup150 = new BackupManagementEagleEYECloudBackup150()

        when:
        Service service = backupManagementEagleEYECloudBackup150.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup150SERVER'
        service.price == 139.95 as double
        service.title == 'eagleEYE Cloud Backup (150GB)'
    }

}
