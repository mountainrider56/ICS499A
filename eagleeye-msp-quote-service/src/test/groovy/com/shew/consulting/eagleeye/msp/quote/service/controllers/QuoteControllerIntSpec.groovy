package com.shew.consulting.eagleeye.msp.quote.service.controllers

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.shew.consulting.eagleeye.msp.quote.service.external.CustomerService
import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Selection
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import com.shew.consulting.eagleeye.msp.quote.service.repository.QuoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import javax.transaction.Transactional
import java.time.Instant

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@ActiveProfiles('test')
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class QuoteControllerIntSpec extends Specification {

    @Autowired
    QuoteRepository quoteRepository

    @Autowired
    Map<String, Service> services

    @Autowired
    ObjectMapper mapper

    MockMvc mockMvc
    CustomerService customerService

    def setup() {
        customerService = Mock()
        QuoteController controller = new QuoteController(quoteRepository, customerService, services)
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    def 'saveQuote'() {
        setup:
        Quote quote = getQuote1()
        double price = 0
        String id = ''
        services.values().forEach({ service ->
            Selection selection = new Selection()
            if (service.price != 0) {
                price = service.price
                id = service.id
            }
            selection.quantity = 0
            quote.selections[service.id] = selection
        })
        quote.selections[id].quantity = 1
        String request = mapper.writeValueAsString(quote)

        when:
        ResultActions actions = mockMvc.perform(put('/v1/quotes')
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        Quote response = mapper.readValue(actions.andReturn().response.contentAsString, Quote)
        response.timestamp != quote.timestamp
        response.selections.size() == quote.selections.size()
        response.customerId == quote.customerId
        response.id == 1
        response.total == price
    }

    @Transactional
    def 'getQuotes'() {
        setup:
        Quote quote1 = quoteRepository.save(getQuote1())
        Quote quote2 = quoteRepository.save(getQuote2())

        when:
        ResultActions actions = mockMvc.perform(get('/v1/quotes'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        List<Quote> quotes = mapper.readValue(actions.andReturn().response.contentAsString,
                new TypeReference<List<Quote>>(){})
        quote1 == quotes.get(0)
        quote2 == quotes.get(1)
    }

    def 'getQuotes - empty list'() {
        when:
        ResultActions actions = mockMvc.perform(get('/v1/quotes'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == '[]'
    }

    @Transactional
    def 'getQuote - happy path'() {
        setup:
        Quote quote1 = quoteRepository.save(getQuote1())
        Quote quote2 = quoteRepository.save(getQuote2())

        when:
        ResultActions actions1 = mockMvc.perform(get("/v1/quotes/${quote1.id}"))
        ResultActions actions2 = mockMvc.perform(get("/v1/quotes/${quote2.id}"))

        then:
        actions1.andExpect(status().isOk())
        actions1.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        quote1 == mapper.readValue(actions1.andReturn().response.contentAsString, Quote)

        actions2.andExpect(status().isOk())
        actions2.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        quote2 == mapper.readValue(actions2.andReturn().response.contentAsString, Quote)
    }

    def 'getQuote - not found'() {
        when:
        ResultActions actions = mockMvc.perform(get('/v1/quotes/1'))

        then:
        actions.andExpect(status().is4xxClientError())
        actions.andReturn().response.errorMessage == 'quote not found: 1'
    }

    def 'getQuoteIdByCustomer'() {
        setup:
        quoteRepository.save(getQuote1())

        when:
        ResultActions actions = mockMvc.perform(get('/v1/quotes/customers/1'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == '1'
    }

    def 'getQuoteIdByCustomer - not found'() {
        setup:
        quoteRepository.save(getQuote1())

        when:
        ResultActions actions = mockMvc.perform(get('/v1/quotes/customers/2'))

        then:
        actions.andExpect(status().is4xxClientError())
        actions.andReturn().response.errorMessage == 'quote not found by customer: 2'
    }

    def 'deleteQuote'() {
        setup:
        quoteRepository.save(getQuote1())

        when:
        ResultActions actions = mockMvc.perform(delete('/v1/quotes/1'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == 'true'
    }

    def 'deleteQuote - false'() {
        setup:
        quoteRepository.save(getQuote1())

        when:
        ResultActions actions = mockMvc.perform(delete('/v1/quotes/2'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == 'false'
    }

    @Transactional
    def 'getQuotePDF'() {
        setup:
        Quote quote = getQuote1()
        Customer customer = new Customer(id: quote.customerId)
        quoteRepository.save(quote)

        when:
        ResultActions actions = mockMvc.perform(get('/v1/quotes/1/files/pdf'))

        then:
        1 * customerService.getCustomer(quote1.customerId) >> customer
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_PDF_VALUE))
        actions.andReturn().response.contentAsString // not null
    }

    def 'getQuotePDF - exception'() {
        setup:
        quoteRepository.save(getQuote1())

        when:
        ResultActions actions = mockMvc.perform(get('/v1/quotes/1/files/pdf'))

        then:
        actions.andExpect(status().is5xxServerError())
        actions.andReturn().response.errorMessage == 'Unable to generate quote: 1'
    }

    def getQuote1() {
        Quote quote = new Quote()
        quote.customerId = 1
        quote.selections = [:]
        services.values().forEach({ service ->
            if (services[service.id].price > 0) {
                Selection selection = new Selection()
                selection.quantity = 5
                quote.selections[service.id] = selection
            }
        })
        quote.total = 0
        quote.timestamp = Instant.now()

        quote
    }

    def getQuote2() {
        Quote quote = new Quote()
        quote.customerId = 2
        quote.selections = [:]
        services.values().forEach({ service ->
            if (services[service.id].price > 0) {
                Selection selection = new Selection()
                selection.quantity = 5
                quote.selections[service.id] = selection
            }
        })
        quote.total = 0
        quote.timestamp = Instant.now()

        quote
    }

}
