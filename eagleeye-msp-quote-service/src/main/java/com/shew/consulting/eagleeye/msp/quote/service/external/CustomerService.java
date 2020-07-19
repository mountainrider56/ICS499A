package com.shew.consulting.eagleeye.msp.quote.service.external;

import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class CustomerService {

    private final RestTemplate restTemplate;

    @Value("${customer.host}")
    private String customerHost;

    public Customer getCustomer(Long customerId) {
        String url = customerHost + "/api/eagleeye-msp/v1/customers/{customerId}";

        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .buildAndExpand(customerId)
                .toUri();

        return restTemplate.getForObject(uri, Customer.class);
    }

}
