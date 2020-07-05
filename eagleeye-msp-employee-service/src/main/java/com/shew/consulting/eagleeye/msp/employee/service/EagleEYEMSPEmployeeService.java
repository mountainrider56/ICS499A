package com.shew.consulting.eagleeye.msp.employee.service;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Main application class for the employee service.
 */
@SpringBootApplication
public class EagleEYEMSPEmployeeService {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .headless(true)
                .bannerMode(Banner.Mode.OFF)
                .sources(EagleEYEMSPEmployeeService.class)
                .run(args);
    }

}
