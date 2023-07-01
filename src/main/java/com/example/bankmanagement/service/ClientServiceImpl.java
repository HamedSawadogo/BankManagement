package com.example.bankmanagement.service;

import com.example.bankmanagement.model.Client;
import com.example.bankmanagement.model.Operation;
import com.example.bankmanagement.model.dtos.ClientDTO;
import com.example.bankmanagement.model.dtos.OperationDto;
import com.example.bankmanagement.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OperationServiveImpl operationServive;

    @Override
    public ClientDTO addclient(ClientDTO client) {
       Client clientsaved=this.convertDtoToEntity(client);
       this.clientRepository.save(clientsaved);
       return this.convertEntityToDto(clientsaved);
    }

    @Override
    public ClientDTO findClientById(Long id) {
        return  convertEntityToDto(this.clientRepository.findById(id).get());
    }
    @Override
    public List<ClientDTO> getAllClients() {
        return  this.clientRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> addAllClients(List<Client> clients) {
        List<Client>clientList=this.clientRepository.saveAll(clients);
        return clientList.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClientBYId(Long clientId) {
        this.clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDTO getClientBYname(String clientName) {
        Client client=this.clientRepository.findClientByNom(clientName);
        return this.modelMapper.map(client,ClientDTO.class);
    }
    @Override
    public ClientDTO convertEntityToDto(Client client) {
        ClientDTO clientDTO=modelMapper.map(client,ClientDTO.class);
        return  clientDTO;
    }

    @Override
    public Client convertDtoToEntity(ClientDTO clientDTO) {
        Client client=new Client();
        client=modelMapper.map(clientDTO,Client.class);
        return client;
    }


}
