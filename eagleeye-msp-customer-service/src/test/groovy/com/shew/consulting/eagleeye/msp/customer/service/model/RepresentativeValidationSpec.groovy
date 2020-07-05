package com.shew.consulting.eagleeye.msp.customer.service.model

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class RepresentativeValidationSpec extends Specification {

    Representative representative
    Validator validator
    ValidatorFactory factory
    Set<ConstraintViolation<Representative>> constraintViolations

    void setup() {
        representative = new Representative()
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    def 'setFirstName - #firstName'() {
        when:
        representative.firstName = firstName
        constraintViolations = validator.validateProperty(representative, 'firstName')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        firstName | message                  | errorSize
        null      | 'First name is required' | 1
        ''        | 'First name is required' | 1
        ' '       | 'First name is required' | 1
        'name'    | null                     | 0
    }

    @Unroll
    def 'setLastName - #lastName'() {
        when:
        representative.lastName = lastName
        constraintViolations = validator.validateProperty(representative, 'lastName')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        lastName | message                 | errorSize
        null     | 'Last name is required' | 1
        ''       | 'Last name is required' | 1
        ' '      | 'Last name is required' | 1
        'name'   | null                    | 0
    }

    @Unroll
    def 'setTelephone - #telephone'() {
        when:
        representative.telephone = telephone
        constraintViolations = validator.validateProperty(representative, 'telephone')

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
        representative.email = email
        constraintViolations = validator.validateProperty(representative, 'email')

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

}
