package com.example.bankmanagement.service;

import com.example.bankmanagement.model.Client;
import com.example.bankmanagement.model.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO addclient(ClientDTO client);
    ClientDTO findClientById(Long id);
    List<ClientDTO>getAllClients();
    List<ClientDTO>addAllClients(List<Client>clients);
    void deleteClientBYId(Long clientId);
    ClientDTO getClientBYname(String clientName);
    ClientDTO convertEntityToDto(Client client);
    Client convertDtoToEntity(ClientDTO clientDTO);

}
