package com.microsevice.voiture_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsevice.voiture_service.controller.ClientServiceClient;
import com.microsevice.voiture_service.entites.Voiture;
import com.microsevice.voiture_service.repository.VoitureRepository;
import com.microservice.client_service.entities.Client;
@Service
public class VoitureService {

  @Autowired
  private VoitureRepository voitureRepository;

  @Autowired
  private ClientServiceClient clientServiceClient;

  public List<Voiture> getVoitures() {
    List <Voiture> voitures = voitureRepository.findAll();

    for (Voiture voiture : voitures) {
        // Fetch client details using Feign client
        Client client = clientServiceClient.getClientById(voiture.getClientID());
        voiture.setClient(client);
    }
    
    return voitures;

  }

  public Voiture getVoitureWithClient(Long voitureId) {
    Voiture voiture = voitureRepository.findById(voitureId).orElse(null);
    if (voiture != null) {
        // Fetch client details using Feign client
        Client client = clientServiceClient.getClientById(voiture.getClientID());
        voiture.setClient(client); 
    }
    return voiture;
}

  public Voiture createVoiture(Voiture voiture) {
    return voitureRepository.save(voiture);
  }

  public void deleteVoiture(Long id) {
    voitureRepository.deleteById(id);
  }



}
