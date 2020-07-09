package com.shew.consulting.eagleeye.msp.quote.service.controllers;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Selection;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import com.shew.consulting.eagleeye.msp.quote.service.repository.BusinessServiceRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/quotes/management/pc")
public class PCManagementController {

    private final BusinessServiceRespository businessServiceRespository;

    @GetMapping("services")
    public Map<String, BusinessService> getServices() {
        Map<String, BusinessService> services = businessServiceRespository.findAllMap();
        Comparator<String> comparator = Comparator.comparingInt(key -> services.get(key).getDisplayOrder());
        Map<String, BusinessService> sortedServices = new TreeMap<>(comparator);
        sortedServices.putAll(services);
        return sortedServices;
    }

    @GetMapping("selections")
    public Map<String, Selection> getEmptySelections() {
        Map<String, BusinessService> services = businessServiceRespository.findAllMap();
        Map<String, Selection> selections = new HashMap<>();
        services.forEach((key, value) -> {
            Selection selection = new Selection();
            selection.setBusinessService(value);
            selection.setQuantity(0);
            value.getBreakdowns().forEach(breakdown -> {
                Selection breakDownSelection = new Selection();
                breakDownSelection.setBusinessService(breakdown);
                breakDownSelection.setQuantity(0);
                selections.put(breakdown.getId(), breakDownSelection);
            });
            selections.put(key, selection);
        });
        return selections;
    }

}
