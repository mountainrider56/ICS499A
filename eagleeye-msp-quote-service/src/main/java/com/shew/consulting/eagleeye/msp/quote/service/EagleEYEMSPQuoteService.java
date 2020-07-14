package com.shew.consulting.eagleeye.msp.quote.service;

import com.shew.consulting.eagleeye.msp.quote.service.configuration.UniqueNameGenerator;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Main application class for the quote service.
 */
@SpringBootApplication
public class EagleEYEMSPQuoteService {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .headless(true)
                .bannerMode(Banner.Mode.OFF)
                .sources(EagleEYEMSPQuoteService.class)
                .beanNameGenerator(new UniqueNameGenerator())
                .run(args);
    }

}
