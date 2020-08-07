package com.shew.consulting.eagleeye.msp.quote.service.external

import com.fasterxml.jackson.databind.ObjectMapper
import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus

@SpringBootTest
class CustomerServiceIntSpec extends Specification {

    @Autowired
    RestTemplate restTemplate

    @Autowired
    CustomerService customerService

    @Autowired
    ObjectMapper mapper

    MockRestServiceServer mockServer

    def setup() {
        mockServer = MockRestServiceServer.createServer(restTemplate)
    }

    def 'getCustomer'() {
        setup:
        Customer customer = new Customer()
        mockServer.expect(requestTo(new URI('http://localhost:8080/api/eagleeye-msp/v1/customers/1')))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(APPLICATION_JSON)
                        .body(mapper.writeValueAsString(customer)))

        when:
        Customer response = customerService.getCustomer(1 as Long)

        then:
        mockServer.verify()
        response == customer
    }

}
