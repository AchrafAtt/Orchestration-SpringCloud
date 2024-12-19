package com.microsevice.voiture_service.repository;

import com.microsevice.voiture_service.entites.Voiture;

import org.springframework.stereotype.Component;

import com.microsevice.voiture_service.dto.VoitureDto;

@Component
public class VoitureMapper {

  public  Voiture toEntity(VoitureDto voitureDTO) {
        return Voiture.builder()
                .id(voitureDTO.getId())
                .marque(voitureDTO.getMarque())
                .modele(voitureDTO.getModele())
                .mtricule(voitureDTO.getMtricule())
                .clientID(voitureDTO.getClientDto().getId())
                .build();
    }

    // Convert DTO to Entity
    public  VoitureDto toDTO(Voiture voiture) {
        return VoitureDto.builder()
                .id(voiture.getId())
                .marque(voiture.getMarque())
                .modele(voiture.getModele())
                .mtricule(voiture.getMtricule())
                .build();
    }
}
