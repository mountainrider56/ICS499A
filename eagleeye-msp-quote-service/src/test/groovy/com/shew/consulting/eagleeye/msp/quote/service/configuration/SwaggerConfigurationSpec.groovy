package com.shew.consulting.eagleeye.msp.quote.service.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.base.Optional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import spock.lang.Specification
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SwaggerConfigurationSpec extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    SwaggerConfiguration configuration

    @Autowired
    ObjectMapper mapper

    def 'api'() {
        setup:
        Docket docket = configuration.api()
        Optional<String> pathMapping = docket['pathMapping'] as Optional<String>

        expect:
        docket // assert not null
        docket.documentationType == DocumentationType.SWAGGER_2
        docket.enabled
        pathMapping.get() == '/'
        !docket['applyDefaultResponseMessages']
    }

    def 'apiInfo'() {
        when:
        ApiInfo apiInfo = configuration.apiInfo()

        then:
        apiInfo // assert not null
        apiInfo.title == 'EagleEYE MSP quote service API'
        apiInfo.version == '1.0'
        apiInfo.license == '(C) Copyright Shew Consulting'
        apiInfo.description == 'List of all endpoints used in API'
    }

    def 'getSwaggerUi'() {
        setup:
        MockHttpServletRequestBuilder getBuilder = get('/swagger-ui.html')

        when:
        ResultActions actions = mockMvc.perform(getBuilder)

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.TEXT_HTML))
    }

}
