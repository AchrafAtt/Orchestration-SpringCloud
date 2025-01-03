package com.microsevice.voiture_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.microsevice.voiture_service.entites.Voiture;
import com.microsevice.voiture_service.service.VoitureService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class VoitureController {

  @Autowired
  private VoitureService voitureService;

  
  @GetMapping("/voitures")
  public List<Voiture> voitures(){
      return voitureService.getVoitures();
  }
  
  @GetMapping("/voiture/{id}")
  public Voiture voiture(@PathVariable Long id) throws Exception{
      return voitureService.getVoitureWithClient(id);
  }

  @PostMapping("/voiture")
  public Voiture createVoiture(@RequestBody Voiture voitureDto) {
    return voitureService.createVoiture(voitureDto);
  }
  
  

  

}
