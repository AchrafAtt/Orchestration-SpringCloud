package com.microsevice.voiture_service.dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "client-service")
public interface ClientService {
    @GetMapping("/client/{id}")
    public ClientDto getClientById(@PathVariable Long id);

}
