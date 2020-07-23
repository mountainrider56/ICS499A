package com.shew.consulting.eagleeye.msp.customer.service.external;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Create a local service to communicate with the quote service.
 */
@Getter
@Setter
@Component
@RequiredArgsConstructor
public class QuoteService {

    private final RestTemplate restTemplate;

    @Value("${quote.host}")
    private String quoteHost;

    public Long getQuoteByCustomerId(Long customerId) {
        String url = quoteHost + "/api/eagleeye-msp/v1/quotes/customers/{customerId}";

        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .buildAndExpand(customerId)
                .toUri();

        try {
            return restTemplate.getForObject(uri, Long.class);
        } catch (HttpStatusCodeException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                return (long) -1;
            }
            throw ex;
        }
    }

    public boolean deleteQuote(Long quoteId) {
        String url = quoteHost + "/api/eagleeye-msp/v1/quotes/{quoteId}";

        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .buildAndExpand(quoteId)
                .toUri();

        return restTemplate.exchange(uri, HttpMethod.DELETE, null, Boolean.class).getBody();
    }

}
