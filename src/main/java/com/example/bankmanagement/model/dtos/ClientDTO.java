package com.example.bankmanagement.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class ClientDTO {

    private Long id;
    private String nom;
    private String email;
    private String telephone;
   // private List<Compte>comptes;
    private List<OperationDto>operations;
}
