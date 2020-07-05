package com.shew.consulting.eagleeye.msp.customer.service.repository;

import com.shew.consulting.eagleeye.msp.customer.service.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create a repository for customer class.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

}
