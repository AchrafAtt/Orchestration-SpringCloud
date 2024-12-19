package com.microsevice.voiture_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.microsevice.voiture_service.entites.Voiture;
import com.microsevice.voiture_service.repository.VoitureRepository;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VoitureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoitureServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(VoitureRepository voitureRepository){
		return args -> {
			voitureRepository.save(new Voiture(null, "BMW", "X6", "1234", 1L));
			voitureRepository.save(new Voiture(null, "Mercedes", "GLC", "5678", 2L));
			voitureRepository.save(new Voiture(null, "Audi", "Q7", "91011", 3L))
			;
			voitureRepository.findAll().forEach(System.out::println);
		};
	}

}
