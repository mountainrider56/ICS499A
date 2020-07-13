package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.periodic.system.optimization

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PeriodicSystemOptimizationDefragSpec extends Specification {

    def 'defineService'() {
        setup:
        PeriodicSystemOptimizationDefrag defrag = new PeriodicSystemOptimizationDefrag()

        when:
        Service service = defrag.defineService()

        then:
        service // not null
        service.id == 'PeriodicSystemOptimizationDefragPC'
        service.price == 0
        service.title == 'Defrag'
    }

}
