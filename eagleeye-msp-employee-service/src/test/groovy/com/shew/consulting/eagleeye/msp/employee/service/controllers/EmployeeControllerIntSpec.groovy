package com.shew.consulting.eagleeye.msp.employee.service.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.shew.consulting.eagleeye.msp.employee.service.exception.handling.GlobalExceptionHandling
import com.shew.consulting.eagleeye.msp.employee.service.model.AccountStatus
import com.shew.consulting.eagleeye.msp.employee.service.model.Employee
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeSave
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeUpdate
import com.shew.consulting.eagleeye.msp.employee.service.model.LoginAttempt
import com.shew.consulting.eagleeye.msp.employee.service.model.SecurityRole
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository
import com.shew.consulting.eagleeye.msp.employee.service.repository.LoginAttemptRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.validation.Validator
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@ActiveProfiles('test')
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeControllerIntSpec extends Specification {

    @Autowired
    EmployeeRepository employeeRepository

    @Autowired
    LoginAttemptRepository loginAttemptRepository

    @Autowired
    PasswordEncoder passwordEncoder

    @Autowired
    Validator validatorFactory

    @Autowired
    ObjectMapper mapper

    MockMvc mockMvc

    def setup() {
        EmployeeController controller = new EmployeeController(employeeRepository, passwordEncoder, loginAttemptRepository)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .setValidator(validatorFactory)
                .build()
    }

    def 'saveEmployee'() {
        setup:
        EmployeeSave employeeSave1 = getEmployeeSave1()
        String request = mapper.writeValueAsString(employeeSave1)
        employeeSave1.id = 1
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request)

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        Employee employee = mapper.readValue(actions.andReturn().response.contentAsString, Employee)
        employeeSave1.id == employee.id
        employeeSave1.username == employee.username
        employeeSave1.firstName == employee.firstName
        employeeSave1.lastName == employee.lastName
        employeeSave1.email == employee.email
        employeeSave1.accountStatus == employee.accountStatus
        !employee.password
    }

    def 'saveEmployee - employee invalid'() {
        setup:
        EmployeeSave employeeSave = new EmployeeSave()
        String request = mapper.writeValueAsString(employeeSave)
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request)
        Map<String, String> expected = [:]
        expected['username'] = 'Username is required'
        expected['firstName'] = 'First name is required'
        expected['lastName'] = 'Last name is required'
        expected['email'] = 'Email is required'
        expected['securityRole'] = 'Security role is required'
        expected['password'] = 'Password is required'
        expected['accountStatus'] = 'Account status is required'

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isBadRequest())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        Map<String, String> result = mapper.readValue(actions.andReturn().response.contentAsString, HashMap.class)
        result.sort() == expected.sort()
    }

    def 'saveEmployee - exception'() {
        setup:
        EmployeeController controller = new EmployeeController(employeeRepository, null, null)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .setValidator(validatorFactory)
                .build()
        EmployeeSave employeeSave1 = getEmployeeSave1()
        String request1 = mapper.writeValueAsString(employeeSave1)
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request1)

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isInternalServerError())
        actions.andReturn().response.errorMessage == 'Unable to save employee.'
    }

    def 'saveEmployee - unavailable username'() {
        setup:
        EmployeeSave employeeSave1 = getEmployeeSave1()
        EmployeeSave employeeSave1Clone = getEmployeeSave1()
        String request1 = mapper.writeValueAsString(employeeSave1)
        employeeSave1.id = 1
        String request2 = mapper.writeValueAsString(employeeSave1Clone)
        MockHttpServletRequestBuilder putBuilder1 = post('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request1)
        MockHttpServletRequestBuilder putBuilder2 = post('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request2)

        when:
        ResultActions actions1 = mockMvc.perform(putBuilder1)
        ResultActions actions2 = mockMvc.perform(putBuilder2)

        then:
        actions1.andExpect(status().isOk())
        actions1.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        Employee employee = mapper.readValue(actions1.andReturn().response.contentAsString, Employee)
        employeeSave1.id == employee.id
        employeeSave1.username == employee.username
        employeeSave1.firstName == employee.firstName
        employeeSave1.lastName == employee.lastName
        employeeSave1.email == employee.email
        employeeSave1.accountStatus == employee.accountStatus
        !employee.getPassword()
        actions2.andExpect(status().isBadRequest())
    }

    @Unroll
    def 'updateEmployee - #accountStatus'() {
        setup:
        EmployeeUpdate employeeSave1 = getEmployeeSave1()
        employeeSave1.accountStatus = accountStatus
        employeeRepository.save(employeeSave1.getEmployee())
        employeeSave1.id = 1 as Long
        loginAttemptRepository.save(new LoginAttempt(employeeSave1.id, beforeAttempt))
        String request = mapper.writeValueAsString(employeeSave1)
        MockHttpServletRequestBuilder putBuilder = put('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request)

        when:
        Optional<LoginAttempt> loginAttemptbefore = loginAttemptRepository.findById(employeeSave1.id)
        ResultActions actions = mockMvc.perform(putBuilder)
        Optional<LoginAttempt> loginAttemptAfter = loginAttemptRepository.findById(employeeSave1.id)

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        Employee employee = mapper.readValue(actions.andReturn().response.contentAsString, Employee)
        employeeSave1.id == employee.id
        employeeSave1.username == employee.username
        employeeSave1.firstName == employee.firstName
        employeeSave1.lastName == employee.lastName
        employeeSave1.email == employee.email
        employeeSave1.accountStatus == employee.accountStatus
        !employee.password
        loginAttemptbefore.get().attempt == beforeAttempt
        loginAttemptAfter.get().attempt == afterAttempt

        where:
        accountStatus        | beforeAttempt | afterAttempt
        AccountStatus.ACTIVE | 4             | 0
        AccountStatus.LOCKED | 4             | 4
    }

    def 'updateEmployee - employee doesn\'t exist'() {
        setup:
        EmployeeUpdate employeeSave1 = getEmployeeSave1()
        employeeSave1.id = 1
        String request = mapper.writeValueAsString(employeeSave1)
        MockHttpServletRequestBuilder putBuilder = put('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request)

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isBadRequest())
        actions.andReturn().response.errorMessage == 'Employee is not existing.'
    }

    def 'updateEmployee - employee invalid'() {
        setup:
        EmployeeSave employeeSave = new EmployeeSave()
        employeeRepository.save(employeeSave1.getEmployee())
        employeeSave1.id = 1
        String request = mapper.writeValueAsString(employeeSave)
        MockHttpServletRequestBuilder putBuilder = put('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request)
        Map<String, String> expected = [:]
        expected['username'] = 'Username is required'
        expected['firstName'] = 'First name is required'
        expected['lastName'] = 'Last name is required'
        expected['email'] = 'Email is required'
        expected['securityRole'] = 'Security role is required'
        expected['accountStatus'] = 'Account status is required'

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isBadRequest())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        Map<String, String> result = mapper.readValue(actions.andReturn().response.contentAsString, HashMap.class)
        result.sort() == expected.sort()
    }

    def 'updateEmployee - exception'() {
        setup:
        EmployeeController controller = new EmployeeController(employeeRepository, null, null)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .setValidator(validatorFactory)
                .build()
        EmployeeSave employeeSave1 = getEmployeeSave1()
        String request1 = mapper.writeValueAsString(employeeSave1)
        MockHttpServletRequestBuilder putBuilder = put('/v1/employees')
                .contentType(MediaType.APPLICATION_JSON).content(request1)

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isBadRequest())
        actions.andReturn().response.errorMessage == 'Unable to update employee.'
    }

    def 'updateEmployee - unavailable username'() {
        setup:
        EmployeeSave employeeSave1 = getEmployeeSave1()
        employeeRepository.save(employeeSave1.getEmployee())
        employeeSave1.id = 1
        EmployeeSave employeeSave1Clone = getEmployeeSave1()
        employeeSave1Clone.id = 2
        String request1 = mapper.writeValueAsString(employeeSave1)
        String request2 = mapper.writeValueAsString(employeeSave1Clone)
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
        Employee employee = mapper.readValue(actions1.andReturn().response.contentAsString, Employee)
        employeeSave1.id == employee.id
        employeeSave1.username == employee.username
        employeeSave1.firstName == employee.firstName
        employeeSave1.lastName == employee.lastName
        employeeSave1.email == employee.email
        employeeSave1.accountStatus == employee.accountStatus
        !employee.password
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
        employeeList                                                         | expectedEmployeeLength
        [getEmployeeSave1().getEmployee(), getEmployeeSave2().getEmployee()] | 2
        []                                                                   | 0
    }

    def 'getEmployee - happy path'() {
        setup:
        Employee expected1 = employeeRepository.save(getEmployeeSave1().getEmployee())
        Employee expected2 = employeeRepository.save(getEmployeeSave2().getEmployee())

        when:
        ResultActions actions1 = mockMvc.perform(get('/v1/employees/1'))
        ResultActions actions2 = mockMvc.perform(get('/v1/employees/2'))

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
        Employee expected1 = employeeRepository.save(getEmployeeSave1().getEmployee())
        Employee expected2 = employeeRepository.save(getEmployeeSave2().getEmployee())

        when:
        ResultActions actions1 = mockMvc.perform(get('/v1/employees/username')
                .contentType(MediaType.APPLICATION_JSON).content('username1'))
        ResultActions actions2 = mockMvc.perform(get('/v1/employees/username')
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
        employeeRepository.save(getEmployeeSave1().getEmployee())
        employeeRepository.save(getEmployeeSave2().getEmployee())

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

    def getEmployeeSave1() {
        EmployeeSave employeeSave = new EmployeeSave()
        employeeSave.username = 'username1'
        employeeSave.firstName = 'firstName1'
        employeeSave.password = 'Password11**'
        employeeSave.password2 = employeeSave.password
        employeeSave.lastName = 'lastName1'
        employeeSave.securityRole = SecurityRole.USER
        employeeSave.email = 'employee1@gmail.com'
        employeeSave.accountStatus = AccountStatus.ACTIVE

        employeeSave
    }

    def getEmployeeSave2() {
        EmployeeSave employeeSave = new EmployeeSave()
        employeeSave.username = 'username2'
        employeeSave.firstName = 'firstName2'
        employeeSave.password = 'Password11**'
        employeeSave.password2 = employeeSave.password
        employeeSave.lastName = 'lastName2'
        employeeSave.securityRole = SecurityRole.ADMIN
        employeeSave.email = 'employee2@gmail.com'
        employeeSave.accountStatus = AccountStatus.ACTIVE

        employeeSave
    }

}
