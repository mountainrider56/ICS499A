package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYEOnsiteBackupStandardRestoreSpec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYEOnsiteBackupStandardRestore backupManagementEagleEYEOnsiteBackupStandardRestore = new BackupManagementEagleEYEOnsiteBackupStandardRestore()

        when:
        Service service = backupManagementEagleEYEOnsiteBackupStandardRestore.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYEOnsiteBackupStandardRestoreSERVER'
        service.price == 0
        service.title == 'Standard Restore'
    }

}
