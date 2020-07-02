package com.shrew.consulting.eagleeye.msp.customer.service.controllers;

import com.shrew.consulting.eagleeye.msp.customer.service.model.Customer;
import com.shrew.consulting.eagleeye.msp.customer.service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Expose endpoints for the customers service.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PutMapping
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found: " + customerId);
    }

}
