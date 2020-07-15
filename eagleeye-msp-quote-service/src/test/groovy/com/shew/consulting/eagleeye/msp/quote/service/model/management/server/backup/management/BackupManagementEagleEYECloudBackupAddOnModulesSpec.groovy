package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYECloudBackupAddOnModulesSpec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYECloudBackupAddOnModules backupManagementEagleEYECloudBackupAddOnModules = new BackupManagementEagleEYECloudBackupAddOnModules()

        when:
        Service service = backupManagementEagleEYECloudBackupAddOnModules.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYECloudBackupAddOnModulesSERVER'
        service.price == 12.50 as double
        service.title == 'Add On Modules'
    }

}
