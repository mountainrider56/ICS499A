package com.shrew.consulting.eagleeye.msp.quote.service.repository;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.stream.Collectors;

public interface ItemRespository extends JpaRepository<Item, String> {

    default Map<String, Item> findAllMap() {
        return findAll().stream().collect(Collectors.toMap(Item::getId, v -> v));
    }

}
