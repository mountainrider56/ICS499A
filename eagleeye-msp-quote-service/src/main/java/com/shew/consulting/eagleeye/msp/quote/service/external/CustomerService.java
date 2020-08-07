package com.shew.consulting.eagleeye.msp.quote.service.external;

import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * A internal service to handle all interactions to the customer service.
 */
@Component
public class CustomerService {

    private final RestTemplate restTemplate;
    private final String customerHost;

    public CustomerService(RestTemplate restTemplate,
                           @Value("${customer.host}") String customerHost) {
        this.restTemplate = restTemplate;
        this.customerHost = customerHost;

    }

    public Customer getCustomer(Long customerId) {
        String url = customerHost + "/api/eagleeye-msp/v1/customers/{customerId}";

        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .buildAndExpand(customerId)
                .toUri();

        return restTemplate.getForObject(uri, Customer.class);
    }

}
