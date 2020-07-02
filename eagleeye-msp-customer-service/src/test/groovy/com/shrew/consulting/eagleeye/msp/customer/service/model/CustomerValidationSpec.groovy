package com.shrew.consulting.eagleeye.msp.customer.service.model

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
    String error

    void setup() {
        customer = new Customer()
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    def 'setName'() {
        when:
        customer.name = name
        constraintViolations = validator.validate(customer)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'name') ? i.message : error
        })

        then:
        error == message

        where:
        name   | message
        null   | 'Name is required'
        ''     | 'Name is required'
        ' '    | 'Name is required'
        'name' | null
    }

    @Unroll
    def 'setTelephone'() {
        when:
        customer.telephone = telephone
        constraintViolations = validator.validate(customer)
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
        customer.email = email
        constraintViolations = validator.validate(customer)
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

    @Unroll
    def 'setAddress1'() {
        when:
        customer.address1 = address1
        constraintViolations = validator.validate(customer)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'address1') ? i.message : error
        })

        then:
        error == message

        where:
        address1 | message
        null     | 'Address is required'
        ''       | 'Address is required'
        ' '      | 'Address is required'
        'test'   | null
    }

    @Unroll
    def 'setCity'() {
        when:
        customer.city = city
        constraintViolations = validator.validate(customer)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'city') ? i.message : error
        })

        then:
        error == message

        where:
        city   | message
        null   | 'City is required'
        ''     | 'City is required'
        ' '    | 'City is required'
        'test' | null
    }

    @Unroll
    def 'setState'() {
        when:
        customer.state = state
        constraintViolations = validator.validate(customer)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'state') ? i.message : error
        })

        then:
        error == message

        where:
        state  | message
        null   | 'State is required'
        ''     | 'Invalid US state'
        ' '    | 'Invalid US state'
        'test' | 'Invalid US state'
        'MN'   | null
        'NY'   | null
    }

    @Unroll
    def 'setZipcode'() {
        when:
        customer.zipcode = zipcode
        constraintViolations = validator.validate(customer)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'zipcode') ? i.message : error
        })

        then:
        error == message

        where:
        zipcode      | message
        null         | 'Zipcode is required'
        ''           | 'Invalid zipcode'
        ' '          | 'Invalid zipcode'
        'test'       | 'Invalid zipcode'
        '55438'      | null
        '55438-'     | 'Invalid zipcode'
        '55438-111'  | 'Invalid zipcode'
        '55438-1111' | null
    }

    @Unroll
    def 'setRepresentative'() {
        when:
        customer.representative = representative
        constraintViolations = validator.validate(customer)
        constraintViolations.forEach({ i ->
            error = (i.propertyPath.toString() == 'representative') ? i.message : error
        })

        then:
        error == message

        where:
        representative | message
        null           | 'Representative is required'
    }

}
