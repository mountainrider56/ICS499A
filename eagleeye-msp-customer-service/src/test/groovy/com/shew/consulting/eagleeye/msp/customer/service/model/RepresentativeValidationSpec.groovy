package com.shew.consulting.eagleeye.msp.customer.service.model

import net.bytebuddy.utility.RandomString
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

    def setup() {
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
        firstName             | message                                                  | errorSize
        null                  | 'First name is required'                                 | 1
        ''                    | 'First name is required'                                 | 1
        ' '                   | 'First name is required'                                 | 1
        RandomString.make(31) | 'First name must be equal to or less than 30 characters' | 1
        RandomString.make(30) | null                                                     | 0
        'name'                | null                                                     | 0
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
        lastName              | message                                                 | errorSize
        null                  | 'Last name is required'                                 | 1
        ''                    | 'Last name is required'                                 | 1
        ' '                   | 'Last name is required'                                 | 1
        RandomString.make(31) | 'Last name must be equal to or less than 30 characters' | 1
        RandomString.make(30) | null                                                    | 0
        'name'                | null                                                    | 0
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
        telephone             | message                        | errorSize
        null                  | 'Telephone number is required' | 1
        ''                    | 'Invalid telephone number'     | 1
        ' '                   | 'Invalid telephone number'     | 1
        '123456'              | 'Invalid telephone number'     | 1
        RandomString.make(13) | 'Invalid telephone number'     | 1
        RandomString.make(18) | 'Invalid telephone number'     | 1
        RandomString.make(14) | null                           | 0
        RandomString.make(17) | null                           | 0
        '(123) 456-7890'      | null                           | 0
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
        email                                | message                                             | errorSize
        null                                 | 'Email is required'                                 | 1
        ''                                   | 'Email is required'                                 | 1
        ' '                                  | 'Invalid email format'                              | 1
        'test'                               | 'Invalid email format'                              | 1
        "${RandomString.make(41)}@gmail.com" | 'Email must be equal to or less than 50 characters' | 1
        "${RandomString.make(40)}@gmail.com" | null                                                | 0
        'test@gmail.com'                     | null                                                | 0
    }

}
