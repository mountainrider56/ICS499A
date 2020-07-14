package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYEOnsiteBackupUniversalRestoreSpec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYEOnsiteBackupUniversalRestore backupManagementEagleEYEOnsiteBackupUniversalRestore = new BackupManagementEagleEYEOnsiteBackupUniversalRestore()

        when:
        Service service = backupManagementEagleEYEOnsiteBackupUniversalRestore.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYEOnsiteBackupUniversalRestoreSERVER'
        service.price == 0
        service.title == 'Universal Restore'
    }

}
