package com.shew.consulting.eagleeye.msp.employee.service.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.shew.consulting.eagleeye.msp.employee.service.model.SecurityRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SecurityRolesControllerIT extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    ObjectMapper mapper

    def 'getSecurityRoles'() {
        when:
        ResultActions actions = mockMvc.perform(get('/v1/employees/security-roles'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == mapper.writeValueAsString(SecurityRole.values())
    }

}
