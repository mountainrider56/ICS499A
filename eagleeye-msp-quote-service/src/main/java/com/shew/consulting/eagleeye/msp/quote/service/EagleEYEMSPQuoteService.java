package com.shew.consulting.eagleeye.msp.quote.service;

import com.shew.consulting.eagleeye.msp.quote.service.configuration.UniqueBeanNameGenerator;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main application class for the quote service.
 */
@SpringBootApplication
@ComponentScan(nameGenerator = UniqueBeanNameGenerator.class)
public class EagleEYEMSPQuoteService {

    public static void main(String[] args) {
            new SpringApplicationBuilder()
                .headless(true)
                .bannerMode(Banner.Mode.OFF)
                .sources(EagleEYEMSPQuoteService.class)
                .run(args);
    }

}
