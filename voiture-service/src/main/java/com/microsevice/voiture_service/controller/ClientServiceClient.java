package com.microsevice.voiture_service.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.client_service.entities.Client;

@FeignClient(name = "client-service", contextId = "clientServiceClient1")
public interface ClientServiceClient {

  @GetMapping("/client/client/{id}")
  public Client getClientById(@PathVariable Long id);

  @GetMapping("client/clients")
  public List<Client> getClients();
}
