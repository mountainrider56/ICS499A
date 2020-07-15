package com.shew.consulting.eagleeye.msp.quote.service.controllers;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Selection;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Expose endpoints for the services service.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/quotes/services")
public class ServiceController {

    private final Map<String, Service> services;

    @GetMapping
    public Map<String, Service> getServices() {
        return services;
    }

    @GetMapping("selections")
    public Map<String, Selection> getEmptySelections() {
        Map<String, Selection> selections = new HashMap<>();
        services.values().forEach(i -> {
            Selection selection = new Selection();
            selection.setQuantity(0);
            selections.put(i.getId(), selection);
        });
        return selections;
    }

}
