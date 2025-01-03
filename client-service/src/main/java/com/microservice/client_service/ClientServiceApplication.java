package com.microservice.client_service;

import com.microservice.client_service.entities.Client;
import com.microservice.client_service.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication

public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	// @Bean
	// CommandLineRunner intialiserBaseH2(ClientRepository clientRepository){
	// 	return args -> {
	// 		clientRepository.save(new Client(null, "client1", 20));
	// 		clientRepository.save(new Client(null, "client2", 30));
	// 		clientRepository.save(new Client(null, "client3", 40));
	// 		clientRepository.save(new Client(null, "client4", 50));
	// 		clientRepository.save(new Client(null, "client5", 60));
	// 	};
	
}
