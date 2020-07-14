package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.periodic.system.optimization

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicSystemOptimizationRemoveTemporaryFilesSpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicSystemOptimizationRemoveTemporaryFiles periodicSystemOptimizationRemoveTemporaryFiles = new PeriodicSystemOptimizationRemoveTemporaryFiles()

        when:
        Service service = periodicSystemOptimizationRemoveTemporaryFiles.defineService()

        then:
        service // not null
        service.id == 'PeriodicSystemOptimizationRemoveTemporaryFilesSERVER'
        service.price == 0
        service.title == 'Remove Temporary Files'
    }

}
