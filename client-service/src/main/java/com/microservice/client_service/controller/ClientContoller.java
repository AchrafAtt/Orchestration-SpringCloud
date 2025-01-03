package com.microservice.client_service.controller;


import com.microservice.client_service.entities.Client;
import com.microservice.client_service.repository.ClientRepository;
import com.microservice.client_service.service.ClientSevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/client")
public class ClientContoller {
    @Autowired
    private ClientSevice clientSevice;


    @PostMapping()
    public void addClient(@RequestBody Client client){
        clientSevice.addClient(client);
    }
    

    @GetMapping("/clients")
    public List<Client> clients(){
        return clientSevice.getClients();
    }

    @GetMapping("/client/{id}")
    public Client client(@PathVariable Long id) throws Exception{
        return clientSevice.getClientById(id);

    }

    


}
