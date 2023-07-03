package com.example.bankmanagement.model.dtos;


import com.example.bankmanagement.enums.StatusType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CompteDto {
    private Long id;

    private float solde;

    @Enumerated(EnumType.STRING)
    private StatusType statusType;

    private String type;
}
