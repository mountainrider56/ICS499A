package com.shew.consulting.eagleeye.msp.customer.service.external

import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.client.RestTemplate
import spock.lang.Specification
import spock.lang.Unroll

class QuoteServiceSpec extends Specification {

    QuoteService quoteService
    RestTemplate restTemplate

    def setup() {
        restTemplate = Mock()
        quoteService = new QuoteService(restTemplate)
        quoteService.setQuoteHost('http://localhost')
    }

    @Unroll
    def 'getQuoteByCustomerId - valid - #id'() {
        when:
        Long result = quoteService.getQuoteByCustomerId(id)

        then:
        1 * restTemplate.getForObject(_ as URI, Long) >> { args ->
            URI uri = ((URI) args.first())
            assert uri.getHost() == 'localhost'
            assert uri.getPath() == "/api/eagleeye-msp/v1/quotes/customers/${id}"
            response()
        }
        result == expected

        where:
        id        | expected   | response
        1 as long | 1 as long  | { 1 as long }
        2 as long | -1 as long | { throw new HttpClientErrorException(HttpStatus.NOT_FOUND) }
    }

    @Unroll
    def 'getQuoteByCustomerId - invalid - #id'() {
        when:
        quoteService.getQuoteByCustomerId(id)

        then:
        1 * restTemplate.getForObject(_ as URI, Long) >> { args ->
            URI uri = ((URI) args.first())
            assert uri.getHost() == 'localhost'
            assert uri.getPath() == "/api/eagleeye-msp/v1/quotes/customers/${id}"
            response()
        }
        thrown(expected)

        where:
        id        | expected                | response
        1 as long | HttpStatusCodeException | { throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST) {} }
        2 as long | RuntimeException        | { throw new RuntimeException() }
    }

    def 'deleteQuote'() {
        when:
        boolean result = quoteService.deleteQuote(id)

        then:
        1 * restTemplate.exchange(_ as URI, HttpMethod.DELETE, null, Boolean) >> { args ->
            URI uri = ((URI) args.first())
            assert uri.getHost() == 'localhost'
            assert uri.getPath() == "/api/eagleeye-msp/v1/quotes/${id}"
            ResponseEntity.status(HttpStatus.OK).body(response)
        }
        result == expected

        where:
        id        | expected | response
        1 as long | true     | true
        2 as long | false    | false
    }

}
