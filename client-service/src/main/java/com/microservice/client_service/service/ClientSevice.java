package com.microservice.client_service.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.client_service.repository.ClientRepository;
import com.microservice.client_service.entities.Client;
@Service
public class ClientSevice {

  @Autowired
  private ClientRepository clientRepository;

  public List<Client> getClients() {
    return clientRepository.findAll();
  }

  public void addClient(Client client) {
    clientRepository.save(client);
  }
  public Client getClientById(Long id) throws Exception {
    return clientRepository.findById(id).orElseThrow(() -> new Exception("Client not found"));
  }
}
