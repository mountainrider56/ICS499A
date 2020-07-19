package com.shew.consulting.eagleeye.msp.employee.service.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.shew.consulting.eagleeye.msp.employee.service.model.Employee
import com.shew.consulting.eagleeye.msp.employee.service.model.SecurityRole
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeControllerIntSpec extends Specification {

    @Autowired
    EmployeeRepository employeeRepository

    @Autowired
    MockMvc mockMvc

    @Autowired
    ObjectMapper mapper

    def 'saveEmployee'() {
        setup:
        Employee employee = getEmployee1()
        String request = mapper.writeValueAsString(employee)
        employee.id = 1
        MockHttpServletRequestBuilder putBuilder = put('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request)

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions.andReturn().response.contentAsString == mapper.writeValueAsString(employee)
    }

    def 'saveEmployee - employee invalid'() {
        setup:
        Employee employee = new Employee()
        String request = mapper.writeValueAsString(employee)
        MockHttpServletRequestBuilder putBuilder = put('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request)
        Map<String, String> expected = [:]
        expected['username'] = 'Username is required'
        expected['firstName'] = 'First name is required'
        expected['lastName'] = 'Last name is required'
        expected['email'] = 'Email is required'
        expected['securityRole'] = 'Security role is required'
        expected['password'] = 'Password is required'

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isBadRequest())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        Map<String, String> result = mapper.readValue(actions.andReturn().response.contentAsString, HashMap.class)
        result.sort() == expected.sort()
    }

    def 'saveEmployee - unavailable username'() {
        setup:
        Employee employee1 = getEmployee1()
        Employee employee2 = getEmployee1()
        String request1 = mapper.writeValueAsString(employee1)
        employee1.id = 1
        String request2 = mapper.writeValueAsString(employee2)
        MockHttpServletRequestBuilder putBuilder1 = put('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request1)
        MockHttpServletRequestBuilder putBuilder2 = put('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request2)

        when:
        ResultActions actions1 = mockMvc.perform(putBuilder1)
        ResultActions actions2 = mockMvc.perform(putBuilder2)

        then:
        actions1.andExpect(status().isOk())
        actions1.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions1.andReturn().response.contentAsString == mapper.writeValueAsString(employee1)

        actions2.andExpect(status().isBadRequest())
    }

    @Unroll
    def 'getEmployees'() {
        setup:
        List<Employee> expected = []
        employeeList.forEach({ i ->
            expected.add(employeeRepository.save(i))
        })

        when:
        ResultActions actions = mockMvc.perform(get('/v1/employees'))

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        expected.size() == expectedEmployeeLength
        actions.andReturn().response.contentAsString == mapper.writeValueAsString(expected)

        where:
        employeeList                     | expectedEmployeeLength
        [getEmployee1(), getEmployee2()] | 2
        []                               | 0
    }

    def 'getEmployee - happy path'() {
        setup:
        Employee expected1 = employeeRepository.save(getEmployee1())
        Employee expected2 = employeeRepository.save(getEmployee2())

        when:
        ResultActions actions1 = mockMvc.perform(get("/v1/employees/1"))
        ResultActions actions2 = mockMvc.perform(get("/v1/employees/2"))

        then:
        actions1.andExpect(status().isOk())
        actions1.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions1.andReturn().response.contentAsString == mapper.writeValueAsString(expected1)

        actions2.andExpect(status().isOk())
        actions2.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions2.andReturn().response.contentAsString == mapper.writeValueAsString(expected2)
    }

    def 'getEmployee - not found'() {
        when:
        ResultActions actions = mockMvc.perform(get('/v1/employees/1'))

        then:
        actions.andExpect(status().is4xxClientError())
        actions.andReturn().response.errorMessage == 'employee not found: 1'
    }

    def 'getEmployeeByUsername - happy path'() {
        setup:
        Employee expected1 = employeeRepository.save(getEmployee1())
        Employee expected2 = employeeRepository.save(getEmployee2())

        when:
        ResultActions actions1 = mockMvc.perform(get("/v1/employees/username")
                .contentType(MediaType.APPLICATION_JSON).content('username1'))
        ResultActions actions2 = mockMvc.perform(get("/v1/employees/username")
                .contentType(MediaType.APPLICATION_JSON).content('username2'))

        then:
        actions1.andExpect(status().isOk())
        actions1.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions1.andReturn().response.contentAsString == mapper.writeValueAsString(expected1)

        actions2.andExpect(status().isOk())
        actions2.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        actions2.andReturn().response.contentAsString == mapper.writeValueAsString(expected2)
    }

    def 'getEmployeeByUsername - not found'() {
        when:
        ResultActions actions = mockMvc.perform(get('/v1/employees/username')
                .contentType(MediaType.APPLICATION_JSON).content('username4'))

        then:
        actions.andExpect(status().is4xxClientError())
        actions.andReturn().response.errorMessage == 'employee not found: username4'
    }

    @Unroll
    def 'deleteEmployee - #id'() {
        setup:
        employeeRepository.save(getEmployee1())
        employeeRepository.save(getEmployee2())

        when:
        ResultActions actions = mockMvc.perform(delete("/v1/employees/${id}"))

        then:
        actions.andExpect(status().isOk())
        actions.andReturn().response.contentAsString == deleted

        where:
        id | deleted
        1  | 'true'
        2  | 'true'
        4  | 'false'
    }

    def getEmployee1() {
        Employee employee = new Employee()
        employee.username = 'username1'
        employee.firstName = 'firstName1'
        employee.password = 'password1'
        employee.lastName = 'lastName1'
        employee.securityRole = SecurityRole.USER
        employee.email = 'employee1@gmail.com'

        employee
    }

    def getEmployee2() {
        Employee employee = new Employee()
        employee.username = 'username2'
        employee.firstName = 'firstName2'
        employee.password = 'password2'
        employee.lastName = 'lastName2'
        employee.securityRole = SecurityRole.ADMIN
        employee.email = 'employee2@gmail.com'

        employee
    }

}
