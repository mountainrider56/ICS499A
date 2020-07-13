package com.shew.consulting.eagleeye.msp.quote.service.controllers;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Selection;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.repository.ServiceRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/quotes/services")
public class ServiceController {

    private final ServiceRespository serviceRespository;

    @GetMapping
    public Map<String, Service> getServices() {
        return serviceRespository.findAllMap();
    }

    @GetMapping("selections")
    public Map<String, Selection> getEmptySelections() {
        Map<String, Service> services = serviceRespository.findAllMap();
        Map<String, Selection> selections = new HashMap<>();
        services.values().parallelStream().forEach(i -> {
            Selection selection = new Selection();
            selection.setQuantity(0);
            selections.put(i.getId(), selection);
        });
        return selections;
    }

}
