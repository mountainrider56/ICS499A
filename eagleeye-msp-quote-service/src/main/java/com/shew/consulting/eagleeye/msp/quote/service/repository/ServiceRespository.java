package com.shew.consulting.eagleeye.msp.quote.service.repository;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create a repository for service class.
 */
@Repository
public interface ServiceRespository extends CrudRepository<Service, String> {

    List<Service> findAll();

    default Map<String, Service> findAllMap() {
        return findAll().stream().collect(Collectors.toMap(Service::getId, v -> v));
    }

}
