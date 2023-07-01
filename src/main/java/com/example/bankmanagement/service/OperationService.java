package com.example.bankmanagement.service;
import com.example.bankmanagement.model.Operation;
import com.example.bankmanagement.model.dtos.OperationDto;
import java.util.List;
import java.util.Optional;

public interface OperationService{
    OperationDto addOperation(OperationDto operation);
    void deleteOperation(Long id);
    Optional<Operation>findOperationById(Long id);
    List<Operation>getAllOperations();
    OperationDto convertEntityToDto(Operation operation);
    List<Operation>getOperationstByClientId(Long clientId);
    public OperationDto converEntityToDto(Operation operation);
    public Operation convertDtoToEntity(OperationDto operationDto);
}
