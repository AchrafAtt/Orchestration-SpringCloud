package com.microservice.client_service.controller;


import com.microservice.client_service.entities.Client;
import com.microservice.client_service.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientContoller {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> clients(){
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public Client client(@PathVariable Long id) throws Exception{
        return clientRepository.findById(id).orElseThrow(()->
                new Exception("Client not found"))    ;
    }


}
