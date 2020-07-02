package com.shrew.consulting.eagleeye.msp.customer.service.data;

import com.shrew.consulting.eagleeye.msp.customer.service.controllers.CustomerController;
import com.shrew.consulting.eagleeye.msp.customer.service.model.Customer;
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
            customer.setTelephone("company" + i + " telephone");
            customer.setAddress1("company" + i + " address1");
            customer.setAddress2("company" + i + " address2");
            customer.setCity("company" + i + " city");
            customer.setState("company" + i + " state");
            customer.setZipcode("company" + i + " zipcode");
            customerController.saveCustomer(customer);
        });
    }

}
