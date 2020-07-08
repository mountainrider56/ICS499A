package com.shew.consulting.eagleeye.msp.quote.service.repository;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface BusinessServiceRespository extends CrudRepository<BusinessService, String> {

    List<BusinessService> findAll();

    default Map<String, BusinessService> findAllMap() {
        return findAll().stream().collect(Collectors.toMap(BusinessService::getId, v -> v));
    }

}
