package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackup15Spec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackup15 backupManagementEagleEYECloudBackup15 = new BackupManagementEagleEYECloudBackup15()

        when:
        Service service = backupManagementEagleEYECloudBackup15.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackup15SERVER'
        service.price == 19.95 as double
        service.title == 'eagleEYE Cloud Backup (15GB)'
    }

}
