package com.shew.consulting.eagleeye.msp.customer.service.model


import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class CustomerValidationSpec extends Specification {

    Customer customer
    Validator validator
    ValidatorFactory factory
    Set<ConstraintViolation<Customer>> constraintViolations

    void setup() {
        customer = new Customer()
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    def 'setName - #name'() {
        when:
        customer.name = name
        constraintViolations = validator.validateProperty(customer, 'name')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        name   | message            | errorSize
        null   | 'Name is required' | 1
        ''     | 'Name is required' | 1
        ' '    | 'Name is required' | 1
        'name' | null               | 0
    }

    @Unroll
    def 'setTelephone - #telephone'() {
        when:
        customer.telephone = telephone
        constraintViolations = validator.validateProperty(customer, 'telephone')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        telephone   | message                        | errorSize
        null        | 'Telephone number is required' | 1
        ''          | 'Invalid telephone number'     | 1
        ' '         | 'Invalid telephone number'     | 1
        '123456'    | 'Invalid telephone number'     | 1
        '123456789' | null                           | 0
    }

    @Unroll
    def 'setEmail - #email'() {
        when:
        customer.email = email
        constraintViolations = validator.validateProperty(customer, 'email')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        email            | message                | errorSize
        null             | 'Email is required'    | 1
        ''               | 'Email is required'    | 1
        ' '              | 'Invalid email format' | 1
        'test'           | 'Invalid email format' | 1
        'test@gmail.com' | null                   | 0
    }

    @Unroll
    def 'setAddress1 - #address1'() {
        when:
        customer.address1 = address1
        constraintViolations = validator.validateProperty(customer, 'address1')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        address1 | message               | errorSize
        null     | 'Address is required' | 1
        ''       | 'Address is required' | 1
        ' '      | 'Address is required' | 1
        'test'   | null                  | 0
    }

    @Unroll
    def 'setCity - #city'() {
        when:
        customer.city = city
        constraintViolations = validator.validateProperty(customer, 'city')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        city   | message            | errorSize
        null   | 'City is required' | 1
        ''     | 'City is required' | 1
        ' '    | 'City is required' | 1
        'test' | null               | 0
    }

    @Unroll
    def 'setState - #state'() {
        when:
        customer.state = state
        constraintViolations = validator.validateProperty(customer, 'state')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        state  | message             | errorSize
        null   | 'State is required' | 1
        ''     | 'Invalid US state'  | 1
        ' '    | 'Invalid US state'  | 1
        'test' | 'Invalid US state'  | 1
        'MN'   | null                | 0
        'NY'   | null                | 0
    }

    @Unroll
    def 'setZipcode - #zipcode'() {
        when:
        customer.zipcode = zipcode
        constraintViolations = validator.validateProperty(customer, 'zipcode')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        zipcode      | message               | errorSize
        null         | 'Zipcode is required' | 1
        ''           | 'Invalid zipcode'     | 1
        ' '          | 'Invalid zipcode'     | 1
        'test'       | 'Invalid zipcode'     | 1
        '55438'      | null                  | 0
        '55438-'     | 'Invalid zipcode'     | 1
        '55438-111'  | 'Invalid zipcode'     | 1
        '55438-1111' | null                  | 0
    }

    @Unroll
    def 'setRepresentative - #representative'() {
        when:
        customer.representative = representative
        constraintViolations = validator.validateProperty(customer, 'representative')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        representative       | message                      | errorSize
        null                 | 'Representative is required' | 1
        new Representative() | null                         | 0
    }

}
