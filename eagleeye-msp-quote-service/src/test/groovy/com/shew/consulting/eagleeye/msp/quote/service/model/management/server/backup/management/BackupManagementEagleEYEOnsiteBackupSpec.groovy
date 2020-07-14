package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementEagleEYEOnsiteBackupSpec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagementEagleEYEOnsiteBackup backupManagementEagleEYEOnsiteBackup = new BackupManagementEagleEYEOnsiteBackup()

        when:
        Service service = backupManagementEagleEYEOnsiteBackup.defineService()

        then:
        service // not null
        service.id == 'BackupManagementEagleEYEOnsiteBackupSERVER'
        service.price == 50
        service.title == 'eagleEYE Onsite Backup'
    }

}
