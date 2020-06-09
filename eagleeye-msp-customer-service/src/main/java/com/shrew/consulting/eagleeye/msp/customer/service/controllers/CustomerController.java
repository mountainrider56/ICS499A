package com.shrew.consulting.eagleeye.msp.customer.service.controllers;

import com.shrew.consulting.eagleeye.msp.customer.service.model.Customer;
import com.shrew.consulting.eagleeye.msp.customer.service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository clientRepository;

    @PutMapping
    public Customer saveCustomer(@ModelAttribute Customer customer) {
        return clientRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return clientRepository.findAll();
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable long customerId) {
        Optional<Customer> customer = clientRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found: " + customerId);
    }

}