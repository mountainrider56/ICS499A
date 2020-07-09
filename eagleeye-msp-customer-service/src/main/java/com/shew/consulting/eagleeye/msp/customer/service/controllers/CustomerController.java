package com.shew.consulting.eagleeye.msp.customer.service.controllers;

import com.shew.consulting.eagleeye.msp.customer.service.model.Customer;
import com.shew.consulting.eagleeye.msp.customer.service.model.projections.CustomerIdAndName;
import com.shew.consulting.eagleeye.msp.customer.service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("ids/names")
    public Map<Long, CustomerIdAndName> getCustomersIdAndName() {
        return customerRepository.getAllBy(CustomerIdAndName.class)
                                 .parallelStream()
                                 .collect(Collectors.toMap(CustomerIdAndName::getId, item -> item));
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found: " + customerId);
    }

    @DeleteMapping("{customerId}")
    public boolean deleteCustomer(@PathVariable Long customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return !customerRepository.existsById(customerId);
        } else {
            return false;
        }
    }

}
