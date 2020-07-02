package com.shrew.consulting.eagleeye.msp.customer.service.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.shrew.consulting.eagleeye.msp.customer.service.model.Customer
import com.shrew.consulting.eagleeye.msp.customer.service.model.Representative
import com.shrew.consulting.eagleeye.msp.customer.service.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CustomerControllerIntSpec extends Specification {

    @Autowired
    CustomerRepository customerRepository

    @Autowired
    MockMvc mockMvc

    @Autowired
    ObjectMapper mapper

    def 'saveCustomer'() {
        setup:
        Customer customer = getCustomer1()
        String request = mapper.writeValueAsString(customer)
        customer.id = 1
        customer.representative.id = 1
        MockHttpServletRequestBuilder putBuilder = put('/v1/customers')
                .contentType(MediaType.APPLICATION_JSON).content(request)

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == mapper.writeValueAsString(customer)
    }

    def 'saveCustomer - customer not valid'() {
        setup:
        Customer customer = new Customer()
        customer.representative = new Representative()
        String request = mapper.writeValueAsString(customer)
        MockHttpServletRequestBuilder putBuilder = put('/v1/customers')
                .contentType(MediaType.APPLICATION_JSON).content(request)
        Map<String, String> expected = [:]
        expected['name'] = 'Name is required'
        expected['telephone'] = 'Telephone number is required'
        expected['email'] = 'Email is required'
        expected['address1'] = 'Address is required'
        expected['city'] = 'City is required'
        expected['state'] = 'State is required'
        expected['zipcode'] = 'Zipcode is required'

        expected['representative.firstName'] = 'First name is required'
        expected['representative.lastName'] = 'Last name is required'
        expected['representative.email'] = 'Email is required'
        expected['representative.telephone'] = 'Telephone number is required'

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isBadRequest())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        Map<String, String> result = mapper.readValue(actions.andReturn().response.contentAsString, HashMap.class);
        result.sort() == expected.sort()
    }

    def 'getCustomers - happy path'() {
        setup:
        Customer customer1 = customerRepository.save(getCustomer1())
        Customer customer2 = customerRepository.save(getCustomer2())

        when:
        ResultActions actions = mockMvc.perform(get('/v1/customers'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == mapper.writeValueAsString([customer1, customer2])
    }

    def 'getCustomers - not found'() {
        when:
        ResultActions actions = mockMvc.perform(get('/v1/customers'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == mapper.writeValueAsString([])
    }

    def 'getCustomer - happy path'() {
        setup:
        Customer customer1 = customerRepository.save(getCustomer1())

        when:
        ResultActions actions = mockMvc.perform(get('/v1/customers/1'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == mapper.writeValueAsString(customer1)
    }

    def 'getCustomer - not found'() {
        when:
        ResultActions actions = mockMvc.perform(get('/v1/customers/1'))

        then:
        actions.andExpect(status().is4xxClientError())
        actions.andReturn().response.contentAsString == ''
    }

    def getCustomer1() {
        Representative representative = new Representative()
        representative.firstName = 'Rep'
        representative.lastName = 'User'
        representative.email = 'Rep.User@gmail.com'
        representative.telephone = '1234567890'

        Customer customer = new Customer()
        customer.name = 'test1'
        customer.telephone = '1234567890'
        customer.email = 'customer1@gmail.com'
        customer.address1 = '1st Ave'
        customer.city = 'Minneapolis'
        customer.state = 'MN'
        customer.zipcode = '55438'
        customer.representative = representative

        customer
    }

    def getCustomer2() {
        Representative representative = new Representative()
        representative.firstName = 'Rep2'
        representative.lastName = 'User'
        representative.email = 'Rep.User@gmail.com'
        representative.telephone = '1234567890'

        Customer customer = new Customer()
        customer.name = 'test2'
        customer.telephone = '1234567890'
        customer.email = 'customer2@gmail.com'
        customer.address1 = '2st Ave'
        customer.city = 'Minneapolis'
        customer.state = 'MN'
        customer.zipcode = '55438'
        customer.representative = representative

        customer
    }

}
