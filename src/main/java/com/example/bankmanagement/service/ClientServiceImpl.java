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

    private List<OperationDto>getClientsOperationsDTO(Long clientId){
        List<Operation>operationList=new ArrayList<>();
        operationList=this.operationServive.getOperationstByClientId(clientId);

        List<OperationDto>operationDtos=new ArrayList<>();
        for (Operation operation:operationList){
            OperationDto dto=new OperationDto();
            dto.setDate(operation.getDate());
            dto.setMontant(operation.getMontant());
            dto.setId(operation.getId());
            dto.setType(operation.getType());
            operationDtos.add(dto);
        }
        return operationDtos;
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
