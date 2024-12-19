package com.microsevice.voiture_service.repository;

import com.microsevice.voiture_service.entites.Voiture;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
