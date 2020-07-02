package com.shrew.consulting.eagleeye.msp.quote.service;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EagleEYEMSPQuoteService {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .headless(true)
                .bannerMode(Banner.Mode.OFF)
                .sources(EagleEYEMSPQuoteService.class)
                .run(args);
    }

}
