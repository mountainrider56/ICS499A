package com.shew.consulting.eagleeye.msp.employee.service.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.cache.LoadingCache
import com.shew.consulting.eagleeye.msp.employee.service.exception.handling.GlobalExceptionHandling
import com.shew.consulting.eagleeye.msp.employee.service.model.AccountStatus
import com.shew.consulting.eagleeye.msp.employee.service.model.Employee
import com.shew.consulting.eagleeye.msp.employee.service.model.Login
import com.shew.consulting.eagleeye.msp.employee.service.model.LoginAttempt
import com.shew.consulting.eagleeye.msp.employee.service.model.SecurityRole
import com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken.JwtResponse
import com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken.JwtToken
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository
import com.shew.consulting.eagleeye.msp.employee.service.repository.LoginAttemptRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@ActiveProfiles('test')
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class LoginControllerIntSpec extends Specification {

    @Autowired
    JwtToken jwtToken

    @Autowired
    EmployeeRepository employeeRepository

    @Autowired
    LoginAttemptRepository loginAttemptRepository

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder

    @Autowired
    LoadingCache<String, Employee> sessionCache

    @Autowired
    ObjectMapper mapper

    MockMvc mockMvc

    def setup() {
        LoginController controller = new LoginController(jwtToken, employeeRepository, loginAttemptRepository,
                bCryptPasswordEncoder, sessionCache)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .build()
    }

    def 'login - no employee found'() {
        setup:
        Login login = new Login(username: 'username', password: 'password')
        String request = mapper.writeValueAsString(login)
        employeeRepository = Mock()
        LoginController controller = new LoginController(jwtToken, employeeRepository, loginAttemptRepository,
                bCryptPasswordEncoder, sessionCache)
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees/login')
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .build()

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        1 * employeeRepository.findEmployeeByUsername(login.username) >> Optional.ofNullable(null)
        actions.andExpect(status().is4xxClientError())
        actions.andReturn().response.errorMessage == LoginController.ERROR_MESSAGE
    }

    def 'login - exception'() {
        setup:
        Login login = new Login(username: 'username', password: 'password')
        String request = mapper.writeValueAsString(login)
        employeeRepository = null
        LoginController controller = new LoginController(jwtToken, employeeRepository, loginAttemptRepository,
                bCryptPasswordEncoder, sessionCache)
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees/login')
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .build()

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().is5xxServerError())
        actions.andReturn().response.errorMessage == LoginController.ERROR_MESSAGE
    }

    def 'login - account locked'() {
        setup:
        Login login = new Login(username: 'username', password: 'password')
        Employee employee = new Employee(accountStatus: AccountStatus.LOCKED)
        String request = mapper.writeValueAsString(login)
        employeeRepository = Mock()
        LoginController controller = new LoginController(jwtToken, employeeRepository, loginAttemptRepository,
                bCryptPasswordEncoder, sessionCache)
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees/login')
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .build()

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        1 * employeeRepository.findEmployeeByUsername(login.username) >> Optional.ofNullable(employee)
        actions.andExpect(status().isBadRequest())
        actions.andReturn().response.errorMessage == 'Account is locked.'
    }

    def 'login - lock account'() {
        setup:
        Login login = new Login(username: 'username', password: 'password1')
        Employee employee = new Employee()
        employee.username = 'username'
        employee.password = 'Password11**'
        employee.firstName = 'firstName'
        employee.lastName = 'lastName'
        employee.email = 'example@gmail.com'
        employee.accountStatus = AccountStatus.ACTIVE
        employee.securityRole = SecurityRole.USER
        employeeRepository.save(employee)
        String request = mapper.writeValueAsString(login)
        LoginController controller = new LoginController(jwtToken, employeeRepository, loginAttemptRepository,
                bCryptPasswordEncoder, sessionCache)
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees/login')
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .build()

        when:
        Optional<LoginAttempt> attempt0 = loginAttemptRepository.findById(employee.id)
        ResultActions actions1 = mockMvc.perform(putBuilder)
        int attempt1 = loginAttemptRepository.findById(employee.id).get().attempt
        ResultActions actions2 = mockMvc.perform(putBuilder)
        int attempt2 = loginAttemptRepository.findById(employee.id).get().attempt
        ResultActions actions3 = mockMvc.perform(putBuilder)
        int attempt3 = loginAttemptRepository.findById(employee.id).get().attempt
        ResultActions actions4 = mockMvc.perform(putBuilder)
        int attempt4 = loginAttemptRepository.findById(employee.id).get().attempt
        ResultActions actions5 = mockMvc.perform(putBuilder)
        int attempt5 = loginAttemptRepository.findById(employee.id).get().attempt
        ResultActions actions6 = mockMvc.perform(putBuilder)
        int attempt6 = loginAttemptRepository.findById(employee.id).get().attempt

        then:
        !attempt0.isPresent()

        actions1.andExpect(status().is4xxClientError())
        actions1.andReturn().response.errorMessage == LoginController.ERROR_MESSAGE

        attempt1 == 1
        actions2.andExpect(status().is4xxClientError())
        actions2.andReturn().response.errorMessage == LoginController.ERROR_MESSAGE

        attempt2 == 2
        actions3.andExpect(status().is4xxClientError())
        actions3.andReturn().response.errorMessage == LoginController.ERROR_MESSAGE

        attempt3 == 3
        actions4.andExpect(status().is4xxClientError())
        actions4.andReturn().response.errorMessage == LoginController.ERROR_MESSAGE

        attempt4 == 4
        actions5.andExpect(status().is4xxClientError())
        actions5.andReturn().response.errorMessage == LoginController.ERROR_MESSAGE

        attempt5 == 5
        actions6.andExpect(status().isBadRequest())
        actions6.andReturn().response.errorMessage == 'Account is locked.'

        attempt6 == 5
    }

    def 'login'() {
        setup:
        Login login = new Login(username: 'username', password: 'Password11**')
        Employee employee = new Employee()
        employee.username = 'username'
        employee.password = bCryptPasswordEncoder.encode('Password11**')
        employee.firstName = 'firstName'
        employee.lastName = 'lastName'
        employee.email = 'example@gmail.com'
        employee.accountStatus = AccountStatus.ACTIVE
        employee.securityRole = SecurityRole.USER
        employeeRepository.save(employee)
        String request = mapper.writeValueAsString(login)
        LoginController controller = new LoginController(jwtToken, employeeRepository, loginAttemptRepository,
                bCryptPasswordEncoder, sessionCache)
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees/login')
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .build()

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        loginAttemptRepository.findById(employee.id).get().attempt == 0
        JwtResponse response = mapper.readValue(actions.andReturn().response.contentAsString, JwtResponse)
        sessionCache.asMap().containsKey(response.token)
    }

    def 'pingSession'() {
        setup:
        Employee employee = new Employee()
        String token = jwtToken.generateToken(employee)
        sessionCache.put(token, employee)
        MockHttpServletRequestBuilder putBuilder = get('/v1/employees/login/ping')
                .contentType(MediaType.APPLICATION_JSON)
                .header('Authorization', token)

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        mapper.readValue(actions.andReturn().response.contentAsString, Boolean)
    }

    def 'pingSession - invalid'() {
        setup:
        MockHttpServletRequestBuilder putBuilder = get('/v1/employees/login/ping')
                .contentType(MediaType.APPLICATION_JSON)
                .header('Authorization', 'BAD_TOKEN')

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        !mapper.readValue(actions.andReturn().response.contentAsString, Boolean)
    }

    def 'pingSession - exception'() {
        setup:
        LoginController controller = new LoginController(jwtToken, employeeRepository, loginAttemptRepository,
                bCryptPasswordEncoder, null)
        MockHttpServletRequestBuilder putBuilder = get('/v1/employees/login/ping')
                .contentType(MediaType.APPLICATION_JSON)
                .header('Authorization', 'BAD_TOKEN')
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .build()

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().is4xxClientError())
        actions.andReturn().response.errorMessage == 'Login not active.'
    }

    def 'logout'() {
        setup:
        Employee employee = new Employee()
        String token = jwtToken.generateToken(employee)
        sessionCache.put(token, employee)
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees/login/logout')
                .contentType(MediaType.APPLICATION_JSON)
                .header('Authorization', token)

        when:
        boolean keyExistsBefore = sessionCache.asMap().containsKey(token)
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        keyExistsBefore
        actions.andExpect(status().isOk())
        !sessionCache.asMap().containsKey(token)
    }

    def 'logout - exception'() {
        setup:
        LoginController controller = new LoginController(jwtToken, employeeRepository, loginAttemptRepository,
                bCryptPasswordEncoder, null)
        MockHttpServletRequestBuilder putBuilder = post('/v1/employees/login/logout')
                .contentType(MediaType.APPLICATION_JSON)
                .header('Authorization', 'BAD_TOKEN')
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandling())
                .build()

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().is5xxServerError())
        actions.andReturn().response.errorMessage == 'Unable to logout.'
    }

    def 'getSession'() {
        setup:
        Employee employee = new Employee()
        String token = jwtToken.generateToken(employee)
        sessionCache.put(token, employee)
        MockHttpServletRequestBuilder putBuilder = get('/v1/employees/login')
                .contentType(MediaType.APPLICATION_JSON)
                .header('Authorization', token)

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().isOk())
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        employee == mapper.readValue(actions.andReturn().response.contentAsString, Employee)
    }

    def 'getSession - invalid/exception'() {
        setup:
        MockHttpServletRequestBuilder putBuilder = get('/v1/employees/login')
                .contentType(MediaType.APPLICATION_JSON)
                .header('Authorization', 'BAD_TOKEN')

        when:
        ResultActions actions = mockMvc.perform(putBuilder)

        then:
        actions.andExpect(status().is4xxClientError())
        actions.andReturn().response.errorMessage == 'Login not active.'
    }

}
