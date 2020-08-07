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
class CustomerIntSpec extends Specification {

    @Autowired
    CustomerRepository customerRepository

    def 'setName - length constraint'() {
        setup:
        Customer customer = customer()
        customer.name = RandomString.make(51)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setTelephone - length constraint'() {
        setup:
        Customer customer = customer()
        customer.telephone = RandomString.make(18)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setEmail - length constraint'() {
        setup:
        Customer customer = customer()
        customer.email = RandomString.make(51)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setAddress1 - length constraint'() {
        setup:
        Customer customer = customer()
        customer.address1 = RandomString.make(51)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setAddress2 - length constraint'() {
        setup:
        Customer customer = customer()
        customer.address2 = RandomString.make(51)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setCity - length constraint'() {
        setup:
        Customer customer = customer()
        customer.city = RandomString.make(51)

        when:
        customerRepository.save(customer)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setZipcode - length constraint'() {
        setup:
        Customer customer = customer()
        customer.zipcode = RandomString.make(6)

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
