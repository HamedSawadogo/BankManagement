package com.example.bankmanagement.service;

import com.example.bankmanagement.model.Operation;
import com.example.bankmanagement.model.dtos.ClientDTO;
import com.example.bankmanagement.model.dtos.OperationDto;
import com.example.bankmanagement.repository.OperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationServiveImpl implements  OperationService{

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public OperationDto addOperation(OperationDto operation) {
        Operation op=this.convertDtoToEntity(operation);
        return this.converEntityToDto(this.operationRepository.save(op));
    }
    @Override
    public void deleteOperation(Long id) {
       this.operationRepository.deleteById(id);
    }
    @Override
    public Optional<Operation> findOperationById(Long id) {
        return this.operationRepository.findById(id);
    }

    @Override
    public List<Operation> getAllOperations() {
        return this.operationRepository.findAll();
    }
    @Override
    public OperationDto convertEntityToDto(Operation operation) {
        return OperationDto.builder()
                .montant(operation.getMontant())
                .date(operation.getDate())
                .type(operation.getType())
                .build();
    }
    @Override
    public List<Operation> getOperationstByClientId(Long clientId) {
        return this.operationRepository.getOperationByClient_Id(clientId);
    }

    @Override
    public OperationDto converEntityToDto(Operation operation) {
        return modelMapper.map(operation,OperationDto.class);
    }

    @Override
    public Operation convertDtoToEntity(OperationDto operationDto) {
        return modelMapper.map(operationDto,Operation.class);
    }
}
