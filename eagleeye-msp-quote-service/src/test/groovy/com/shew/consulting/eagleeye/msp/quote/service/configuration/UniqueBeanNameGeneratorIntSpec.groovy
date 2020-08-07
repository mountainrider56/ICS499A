package com.shew.consulting.eagleeye.msp.quote.service.configuration

import com.shew.consulting.eagleeye.msp.quote.service.external.CustomerService
import com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.asset.warranty.management.AssetWarrantyManagement
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.GenericBeanDefinition
import spock.lang.Specification
import spock.lang.Unroll

class UniqueBeanNameGeneratorIntSpec extends Specification {

    @Unroll
    def 'generateBeanName - #clazz'() {
        setup:
        UniqueBeanNameGenerator uniqueBeanNameGenerator = new UniqueBeanNameGenerator()
        BeanDefinition beanDefinition = new GenericBeanDefinition()
        beanDefinition.setBeanClass(clazz)
        BeanDefinitionRegistry registry = Mock()

        when:
        String name = uniqueBeanNameGenerator.generateBeanName(beanDefinition, registry)

        then:
        name == expectString

        where:
        clazz                   | expectString
        AssetWarrantyManagement | 'com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.asset.warranty.management.AssetWarrantyManagement'
        CustomerService         | 'customerService'
    }

}
