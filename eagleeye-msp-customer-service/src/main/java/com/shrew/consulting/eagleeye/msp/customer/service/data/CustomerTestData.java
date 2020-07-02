package com.shrew.consulting.eagleeye.msp.customer.service.data;

import com.shrew.consulting.eagleeye.msp.customer.service.controllers.CustomerController;
import com.shrew.consulting.eagleeye.msp.customer.service.model.Customer;
import com.shrew.consulting.eagleeye.msp.customer.service.model.Representative;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class CustomerTestData {

    private final CustomerController customerController;

    @PostConstruct
    public void postConstruct() {
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
            customerController.saveCustomer(customer);
        });
    }

}
