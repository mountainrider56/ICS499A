package com.shew.consulting.eagleeye.msp.customer.service.data;

import com.shew.consulting.eagleeye.msp.customer.service.model.Customer;
import com.shew.consulting.eagleeye.msp.customer.service.model.Representative;
import com.shew.consulting.eagleeye.msp.customer.service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

/**
 * Add test data on service startup.
 */
@Component
@Profile("testData")
@RequiredArgsConstructor
public class CustomerTestData {

    private final CustomerRepository customerRepository;

    @EventListener
    public void applicationReady(ApplicationReadyEvent event) {
        System.out.println(event);
        IntStream.range(0, 10).forEach(i -> {
            Customer customer = new Customer();
            customer.setName("test company" + i);
            customer.setTelephone("1234567890");
            customer.setEmail("company" + i + "@gmail.com");
            customer.setAddress1("company" + i + " address1");
            customer.setAddress2("company" + i + " address2");
            customer.setCity("company" + i + " city");
            customer.setState("MN");
            customer.setZipcode("55438");
            Representative representative = new Representative();
            representative.setFirstName("First" + i);
            representative.setLastName("Last" + i);
            representative.setEmail("rep" + i + "@gmail.com");
            representative.setTelephone("1234567890");
            customer.setRepresentative(representative);
            customerRepository.save(customer);
        });
    }

}
