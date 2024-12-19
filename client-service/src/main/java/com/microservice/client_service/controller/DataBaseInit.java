package com.microservice.client_service.controller;

import com.microservice.client_service.entities.Client;
import com.microservice.client_service.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataBaseInit {
    @Bean
    CommandLineRunner initializeDatabase(ClientRepository clientRepository) {
        return args -> {
            // Create and save 10 clients
            List<Client> clients = List.of(
                    Client.builder().nom("John Doe").age(25.5f).build(),
                    Client.builder().nom("Jane Smith").age(30.0f).build(),
                    Client.builder().nom("Alice Johnson").age(22.3f).build(),
                    Client.builder().nom("Bob Brown").age(35.0f).build());

            clientRepository.saveAll(clients);
            System.out.println("Database initialized with 10 clients.");
  };
}

}
