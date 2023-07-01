package com.example.bankmanagement.controller;

import com.example.bankmanagement.model.Client;
import com.example.bankmanagement.model.dtos.ClientDTO;
import com.example.bankmanagement.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;


    @PostMapping("/api/add")
    public  ClientDTO addClient(@RequestBody  ClientDTO clientDTO){
         System.out.println(clientDTO.getNom());
         System.out.println(clientDTO.getTelephone());
         return  this.clientService.addclient(clientDTO);
    }
    @GetMapping("/api/clients")
    private List<ClientDTO>getAllClients(){
        return  this.clientService.getAllClients();
    }

    @GetMapping("/api/client/{id}")
    public ClientDTO findClientById(@PathVariable("id") Long clientId){
        return  this.clientService.findClientById(clientId);
    }

    @DeleteMapping("/api/client/{id}")
    public  void deleteClientById(@PathVariable("id") Long clientId){
        this.clientService.deleteClientBYId(clientId);
    }
}
