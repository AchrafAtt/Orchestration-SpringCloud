package com.microsevice.voiture_service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.microservice.client_service.entities.Client;
import com.microsevice.voiture_service.controller.ClientServiceClient;
import com.microsevice.voiture_service.entites.Voiture;
import com.microsevice.voiture_service.repository.VoitureRepository;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VoitureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoitureServiceApplication.class,args);
	}
	
	@Bean
CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientServiceClient clientServiceClient) {
    return args -> {
        try {
            // Fetch all clients from ClientService
            List<Client> clients = clientServiceClient.getClients();

            if (clients != null && !clients.isEmpty()) {
                //get first client
								Client client = clients.get(0);
								voitureRepository.save(new Voiture(null, "BMW", "model1", "matricule1", client.getId(), client));
            } else {
                System.err.println("No clients found in ClientService.");
            }
        } catch (Exception e) {
            System.err.println("Error fetching clients from ClientService: " + e.getMessage());
        }
    };
}
}


