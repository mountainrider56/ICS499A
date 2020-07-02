package com.shrew.consulting.eagleeye.msp.quote.service.controllers;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;
import com.shrew.consulting.eagleeye.msp.quote.service.repository.ItemRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("v1/quotes/pc-management")
@RequiredArgsConstructor
public class PCManagementController {

    private final ItemRespository itemRespository;

    @GetMapping("/items")
    public Map<String, Item> getItems() {
        return itemRespository.findAllMap();
    }

}
