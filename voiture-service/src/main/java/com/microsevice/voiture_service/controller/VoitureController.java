package com.microsevice.voiture_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microsevice.voiture_service.dto.VoitureDto;
import com.microsevice.voiture_service.dto.VoitureService;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class VoitureController {

  @Autowired
  private VoitureService voitureService;

  
  @GetMapping("/voitures")
  public List<VoitureDto> voitures(){
      return voitureService.getVoitures();
  }
  
  @GetMapping("/voiture/{id}")
  public VoitureDto voiture(@PathVariable Long id) throws Exception{
      return voitureService.getVoiture(id);
  }

  @PostMapping("/voiture")
  public VoitureDto createVoiture(@RequestBody VoitureDto voitureDto) {
    return voitureService.createVoiture(voitureDto);
  }
  
  

  

}
