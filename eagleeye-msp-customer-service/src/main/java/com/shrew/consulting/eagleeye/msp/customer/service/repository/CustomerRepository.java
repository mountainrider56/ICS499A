package com.shrew.consulting.eagleeye.msp.customer.service.repository;

import com.shrew.consulting.eagleeye.msp.customer.service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
