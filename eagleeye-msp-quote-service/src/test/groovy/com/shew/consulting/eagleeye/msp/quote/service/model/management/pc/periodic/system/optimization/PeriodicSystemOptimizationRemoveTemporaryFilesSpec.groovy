package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.periodic.system.optimization

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicSystemOptimizationRemoveTemporaryFilesSpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicSystemOptimizationRemoveTemporaryFiles removeTemporaryFiles = new PeriodicSystemOptimizationRemoveTemporaryFiles()

        when:
        Service service = removeTemporaryFiles.defineService()

        then:
        service // not null
        service.id == 'PeriodicSystemOptimizationRemoveTemporaryFilesPC'
        service.price == 0
        service.title == 'Remove Temporary Files'
    }

}
