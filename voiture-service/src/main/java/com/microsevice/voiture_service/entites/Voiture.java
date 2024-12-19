package com.microsevice.voiture_service.entites;

import com.microsevice.voiture_service.dto.ClientDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voiture {
    @Id
    @GeneratedValue
    private Long id;
    private String marque;
    private String modele;
    private String mtricule;
    private Long clientID;
  
}
