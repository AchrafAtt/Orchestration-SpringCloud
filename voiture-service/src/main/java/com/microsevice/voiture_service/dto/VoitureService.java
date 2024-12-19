package com.microsevice.voiture_service.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.microsevice.voiture_service.repository.VoitureRepository;
import com.microsevice.voiture_service.entites.Voiture;
import com.microsevice.voiture_service.repository.VoitureMapper;


@Service
@RequiredArgsConstructor


public class VoitureService {

  private final VoitureRepository voitureRepository;
  private final VoitureMapper voitureMapper;
  private final ClientService clientService;

  // Create a new Voiture
  public VoitureDto createVoiture(VoitureDto voitureDto) {
      Voiture voiture = voitureMapper.toEntity(voitureDto);
      Voiture savedVoiture = voitureRepository.save(voiture);
      return voitureMapper.toDTO(savedVoiture);
  }

  // Get a list of all Voitures with their corresponding Client information
  public List<VoitureDto> getVoitures() {
      List<Voiture> voitures = voitureRepository.findAll();
      return voitures.stream().map(voiture -> {
          // Fetch client details if clientID is present
          ClientDto clientDto = null;
          if (voiture.getClientID() != null) {
              clientDto = clientService.getClientById(voiture.getClientID());
          }

          // Map Voiture to VoitureDto and set ClientDto
          VoitureDto voitureDto = voitureMapper.toDTO(voiture);
          voitureDto.setClientDto(clientDto);
          return voitureDto;
      }).collect(Collectors.toList());
  }

  // Get a single Voiture by ID
  public VoitureDto getVoiture(Long id) {
      Voiture voiture = voitureRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Voiture not found with ID: " + id));
      
      // Fetch client details if clientID is present
      ClientDto clientDto = null;
      if (voiture.getClientID() != null) {
          clientDto = clientService.getClientById(voiture.getClientID());
      }

      // Map Voiture to VoitureDto and set ClientDto
      VoitureDto voitureDto = voitureMapper.toDTO(voiture);
      voitureDto.setClientDto(clientDto);
      return voitureDto;
  }

}
