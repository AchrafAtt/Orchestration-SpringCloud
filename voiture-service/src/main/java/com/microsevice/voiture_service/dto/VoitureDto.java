package com.microsevice.voiture_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoitureDto {

  private Long id;
    private String marque;
    private String modele;
    private String mtricule;
    private ClientDto clientDto;
  }
