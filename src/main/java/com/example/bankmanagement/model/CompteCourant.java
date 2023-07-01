package com.example.bankmanagement.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;


@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{

    @Transient
    private static final float tauxInteret= 0.2F;
}
