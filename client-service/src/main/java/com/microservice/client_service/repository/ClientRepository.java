package com.microservice.client_service.repository;

import com.microservice.client_service.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
  
  Client getClientById(Long id);
}
