package com.shrew.consulting.eagleeye.msp.customer.service.model

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
    Set<ConstraintViolation<Customer>> constraintViolations
    String error

    void setup() {
        representative = new Representative()
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    def 'setFirstName'() {
        when:
        representative.firstName = firstName
        constraintViolations = validator.validate(representative)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'firstName') ? i.message : error
        })

        then:
        error == message

        where:
        firstName | message
        null      | 'First name is required'
        ''        | 'First name is required'
        ' '       | 'First name is required'
        'name'    | null
    }

    @Unroll
    def 'setLastName'() {
        when:
        representative.lastName = lastName
        constraintViolations = validator.validate(representative)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'lastName') ? i.message : error
        })

        then:
        error == message

        where:
        lastName | message
        null     | 'Last name is required'
        ''       | 'Last name is required'
        ' '      | 'Last name is required'
        'name'   | null
    }

    @Unroll
    def 'setTelephone'() {
        when:
        representative.telephone = telephone
        constraintViolations = validator.validate(representative)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'telephone') ? i.message : error
        })

        then:
        error == message

        where:
        telephone   | message
        null        | 'Telephone number is required'
        ''          | 'Invalid telephone number'
        ' '         | 'Invalid telephone number'
        '123456'    | 'Invalid telephone number'
        '123456789' | null
    }

    @Unroll
    def 'setEmail'() {
        when:
        representative.email = email
        constraintViolations = validator.validate(representative)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'email') ? i.message : error
        })

        then:
        error == message

        where:
        email            | message
        null             | 'Email is required'
        ''               | 'Email is required'
        ' '              | 'Invalid email format'
        'test'           | 'Invalid email format'
        'test@gmail.com' | null
    }

}
