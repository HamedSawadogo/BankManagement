package com.example.bankmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Table
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Client implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public  Client(String nom,String email,String telephone){
        this.nom=nom;
        this.email=email;
        this.telephone=telephone;
    }
    @Column(nullable = false,length = 30)
    private String nom;

    @Column(length = 30)
    private String email;

    @Column(length = 11)
    private String telephone;

    //liste des comptes du client
    @OneToMany(fetch = FetchType.LAZY)
    private List<Compte>comptes;


    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Operation>operations;

    //toString
    @Override
    public String toString() {
        return "Nom:  =>"+nom+"  email:  =>"+email+"  telephone:  =>"+telephone;
    }
}

