package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.periodic.system.optimization

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicSystemOptimizationScanDiskSpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicSystemOptimizationScanDisk periodicSystemOptimizationScanDisk = new PeriodicSystemOptimizationScanDisk()

        when:
        Service service = periodicSystemOptimizationScanDisk.defineService()

        then:
        service // not null
        service.id == 'PeriodicSystemOptimizationScanDiskSERVER'
        service.price == 0
        service.title == 'Scan Disk'
    }

}
