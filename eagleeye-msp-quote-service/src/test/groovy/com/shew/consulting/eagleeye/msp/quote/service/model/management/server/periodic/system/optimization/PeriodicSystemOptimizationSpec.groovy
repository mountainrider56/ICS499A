package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.periodic.system.optimization


import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicSystemOptimizationSpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicSystemOptimization periodicSystemOptimization = new PeriodicSystemOptimization()

        when:
        Service service = periodicSystemOptimization.defineService()

        then:
        service // not null
        service.id == 'PeriodicSystemOptimizationSERVER'
        service.price == 50
        service.title == 'Periodic System Optimization'
    }

}
