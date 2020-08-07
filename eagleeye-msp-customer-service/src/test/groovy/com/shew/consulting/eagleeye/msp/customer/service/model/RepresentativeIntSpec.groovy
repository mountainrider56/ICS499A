package com.shew.consulting.eagleeye.msp.customer.service.model

import com.shew.consulting.eagleeye.msp.customer.service.repository.CustomerRepository
import net.bytebuddy.utility.RandomString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles('test')
@TestPropertySource(properties = [
        'spring.jpa.properties.javax.persistence.validation.mode=none'
])
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class RepresentativeIntSpec extends Specification {

    @Autowired
    CustomerRepository customerRepository

    def 'setFirstName - length constraint'() {
        setup:
        Customer customer = customer()
        customer.representative.firstName = RandomString.make(31)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setLastName - length constraint'() {
        setup:
        Customer customer = customer()
        customer.representative.lastName = RandomString.make(31)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setTelephone - length constraint'() {
        setup:
        Customer customer = customer()
        customer.representative.telephone = RandomString.make(18)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setEmail - length constraint'() {
        setup:
        Customer customer = customer()
        customer.representative.email = RandomString.make(51)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    private static Customer customer() {
        Customer customer = new Customer()
        customer.setName("Savvy Action")
        customer.setTelephone("(752) 920-6450")
        customer.setEmail("contact@SavvyAction.com")
        customer.setAddress1("9219 Wood Lane")
        customer.setCity("Minneapolis")
        customer.setState(USState.MN)
        customer.setZipcode("55111")
        Representative representative = new Representative()
        representative.setFirstName("Maegan")
        representative.setLastName("Talley")
        representative.setEmail("Maegan.C.Talley@SavvyAction.com")
        representative.setTelephone("(804) 326-8065")
        customer.setRepresentative(representative)

        customer
    }

}
