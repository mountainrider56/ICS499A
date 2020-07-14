package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class BackupManagementSpec extends Specification {

    def 'defineService'() {
        setup:
        BackupManagement backupManagement = new BackupManagement()

        when:
        Service service = backupManagement.defineService()

        then:
        service // not null
        service.id == 'BackupManagementSERVER'
        service.price == 0
        service.title == 'Backup Management'
    }

}
