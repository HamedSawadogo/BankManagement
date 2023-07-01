package com.example.bankmanagement.model;

import com.example.bankmanagement.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)
public abstract class Compte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float solde;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType statusType;

    //client propriétaire du Compte
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Client client;

}
