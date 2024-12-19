package com.microservice.client_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private double age;


    public Client(Long id, String name, double age) {
        this.id = id;
        this.nom = name;
        this.age = age;
    }

    public Client() {}
}
