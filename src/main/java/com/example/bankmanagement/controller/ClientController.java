package com.example.bankmanagement.controller;
import com.example.bankmanagement.model.dtos.ClientDTO;
import com.example.bankmanagement.model.dtos.OperationDto;
import com.example.bankmanagement.service.ClientServiceImpl;
import com.example.bankmanagement.service.OperationServiveImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private OperationServiveImpl operationServive;

    @GetMapping("/api/client/name/{name}")
    public  ClientDTO getClientByName(@PathVariable("name")String clientName){
        return  this.clientService.getClientBYname(clientName);
    }
    @PostMapping("/api/client/operation/{id}")
    public OperationDto addOperationToClient(@PathVariable("id")Long clientId,@RequestBody  OperationDto operationDto){

        ClientDTO clientDTO=this.clientService.findClientById(clientId);
        operationDto.setClient(clientDTO);
        this.operationServive.addOperation(operationDto);
        clientDTO.getOperations().add(operationDto);

        this.clientService.addclient(clientDTO);
        return  operationDto;
    }
    @PostMapping("/api/add")
    public  ClientDTO addClient(@RequestBody  ClientDTO clientDTO){
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
