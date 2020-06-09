package com.shrew.consulting.eagleeye.msp.customer.service.controllers

import com.shrew.consulting.eagleeye.msp.customer.service.model.Customer
import com.shrew.consulting.eagleeye.msp.customer.service.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import spock.lang.Specification

class CustomerControllerSpec extends Specification {

    CustomerRepository customerRepository
    CustomerController customerController

    void setup() {
        customerRepository = Mock()
        customerController = new CustomerController(customerRepository)
    }

    def 'save customer'() {
        setup:
        Customer customer = new Customer()

        when:
        long response = customerController.saveCustomer(customer)

        then:
        1 * customerRepository.save(customer) >> customer
        0 * _ // no more calls
        response == 0
    }

    def 'get customers'() {
        setup:
        Customer customer1 = new Customer()
        Customer customer2 = new Customer()

        when:
        List<Customer> customers = customerController.getCustomers()

        then:
        1 * customerRepository.findAll() >> [customer1, customer2]
        0 * _ // no more calls
        customers == [customer1, customer2]
    }

    def 'get customer'() {
        setup:
        Optional<Customer> optional = new Optional<>(new Customer())

        when:
        Customer response = customerController.getCustomer(0)

        then:
        1 * customerRepository.findById(0) >> optional
        0 * _ // no more calls
        response == optional.get()
    }

    def 'get customer - 404'() {
        setup:
        Optional<Customer> optional = new Optional<>()

        when:
        customerController.getCustomer(0)

        then:
        1 * customerRepository.findById(0) >> optional
        0 * _ // no more calls
        ResponseStatusException ex = thrown()
        ex.message == '404 NOT_FOUND "customer not found: 0"'
        ex.status == HttpStatus.NOT_FOUND
    }

}
