package com.shew.consulting.eagleeye.msp.quote.service.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.repository.QuoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import java.time.Instant

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class QuoteControllerIT extends Specification {

    @Autowired
    QuoteRepository quoteRepository

    @Autowired
    MockMvc mockMvc

    @Autowired
    ObjectMapper mapper

    def 'getQuotes'() {
        setup:
        Quote quote1 = quoteRepository.save(getQuote1())
        Quote quote2 = quoteRepository.save(getQuote2())

        when:
        ResultActions actions = mockMvc.perform(get('/v1/quotes'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == mapper.writeValueAsString([quote1, quote2])
    }

    def 'getQuote - happy path'() {
        setup:
        Quote quote1 = quoteRepository.save(getQuote1())
        Quote quote2 = quoteRepository.save(getQuote2())

        when:
        ResultActions actions1 = mockMvc.perform(get("/v1/quotes/1"))
        ResultActions actions2 = mockMvc.perform(get("/v1/quotes/2"))

        then:
        actions1.andExpect(status().isOk())
        actions1.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions1.andReturn().response.contentAsString == mapper.writeValueAsString(quote1)

        actions2.andExpect(status().isOk())
        actions2.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions2.andReturn().response.contentAsString == mapper.writeValueAsString(quote2)
    }

    def 'getQuote - not found'() {
        when:
        ResultActions actions = mockMvc.perform(get('/v1/quotes/1'))

        then:
        actions.andExpect(status().is4xxClientError())
        actions.andReturn().response.errorMessage == 'quote not found: 1'
    }

    def getQuote1() {
        Quote quote = new Quote()
        quote.customerId = 1
        quote.selections = [:]
        quote.total = 0
        quote.timestamp = Instant.now()

        quote
    }

    def getQuote2() {
        Quote quote = new Quote()
        quote.customerId = 2
        quote.selections = [:]
        quote.total = 0
        quote.timestamp = Instant.now()

        quote
    }

}
