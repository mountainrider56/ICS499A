package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.periodic.system.optimization

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicSystemOptimizationDefragSpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicSystemOptimizationDefrag periodicSystemOptimizationDefrag = new PeriodicSystemOptimizationDefrag()

        when:
        Service service = periodicSystemOptimizationDefrag.defineService()

        then:
        service // not null
        service.id == 'PeriodicSystemOptimizationDefragSERVER'
        service.price == 0
        service.title == 'Defrag'
    }

}
