package com.shrew.consulting.eagleeye.msp.service.repository;

import com.shrew.consulting.eagleeye.msp.service.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findById(long id);

}
