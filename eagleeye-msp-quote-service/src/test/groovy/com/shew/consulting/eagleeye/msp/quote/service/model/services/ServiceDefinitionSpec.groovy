package com.shew.consulting.eagleeye.msp.quote.service.model.services

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType
import spock.lang.Specification

class ServiceDefinitionSpec extends Specification {

    def 'service definition'() {
        setup:
        Service service = new Service('1', 'test', 0)
        ServiceDefinition serviceDefinition = new ServiceDefinition() {

            @Override
            Service defineService() {
                return service
            }

        }

        expect:
        serviceDefinition.defineService() == service
        serviceDefinition.getId(ManagementType.PC) == 'PC'
    }

}
