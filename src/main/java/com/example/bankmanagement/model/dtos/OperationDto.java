package com.example.bankmanagement.model.dtos;


import com.example.bankmanagement.enums.OperationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class OperationDto {

    private Long id;
    private float montant;
    private Date date;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    //private ClientDTO client;
}
