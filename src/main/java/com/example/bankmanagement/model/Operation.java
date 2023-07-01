package com.example.bankmanagement.model;


import com.example.bankmanagement.enums.OperationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Table
@Entity @NoArgsConstructor @AllArgsConstructor
public class Operation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float montant;
    private Date date;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client client;
}
