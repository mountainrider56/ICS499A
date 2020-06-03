package com.shrew.consulting.eagleeye.msp.service.controllers;

import com.shrew.consulting.eagleeye.msp.service.model.Client;
import com.shrew.consulting.eagleeye.msp.service.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;

    @PutMapping("clients")
    private long saveClient(@ModelAttribute Client client) {
        return clientRepository.save(client).getId();
    }

    @GetMapping("clients/{clientId}")
    private Client getClient(@PathVariable long clientId) {
        return clientRepository.findById(clientId);
    }

}
