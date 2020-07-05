package com.shew.consulting.eagleeye.msp.customer.service;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Main application class for the customer service.
 */
@SpringBootApplication
public class EagleEYEMSPCustomerService {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .headless(true)
                .bannerMode(Banner.Mode.OFF)
                .sources(EagleEYEMSPCustomerService.class)
                .run(args);
    }

}
