package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackupBrickLevelUsersSpec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackupBrickLevelUsers backupManagementEagleEYECloudBackupBrickLevelUsers = new BackupManagementEagleEYECloudBackupBrickLevelUsers()

        when:
        Service service = backupManagementEagleEYECloudBackupBrickLevelUsers.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackupBrickLevelUsersSERVER'
        service.price == 1
        service.title == 'Brick Level Users'
    }

}
