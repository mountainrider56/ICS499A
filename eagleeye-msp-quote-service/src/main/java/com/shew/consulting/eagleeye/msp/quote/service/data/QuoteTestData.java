package com.shew.consulting.eagleeye.msp.quote.service.data;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Selection;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.repository.QuoteRepository;
import com.shew.consulting.eagleeye.msp.quote.service.repository.ServiceRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Load all test data after application starts.
 */
@Component
@Order(2)
@Profile("testData")
@RequiredArgsConstructor
public class QuoteTestData {

    private final QuoteRepository quoteRepository;
    private final ServiceRespository serviceRespository;

    @EventListener
    public void applicationReady(ApplicationReadyEvent event) {
        System.out.println(event);
        Map<String, Service> services = serviceRespository.findAllMap();
        IntStream.range(0, 10).forEach(i -> {
            Quote quote = new Quote();
            Map<String, Selection> selections = new HashMap<>();
            services.values().parallelStream().forEach(ii -> {
                if (ii.getPrice() > 0) {
                    int quantity = getRandomInt();
                    double price = quantity * ii.getPrice();
                    quote.setTotal(quote.getTotal() + price);
                    selections.put(ii.getId(), new Selection(null, quantity));
                }
            });
            quote.setSelections(selections);
            quote.setCustomerId((long) (i + 1));
            quote.setTimestamp(Instant.now());
            quoteRepository.save(quote);
        });
    }

    private int getRandomInt() {
        return (int) (Math.random() * (10) + 1);
    }

}
