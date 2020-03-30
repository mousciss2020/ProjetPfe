package com.projetPfe.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @ToString
public class Banque implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nom_Banque")
    private String nomBanque;
    
    @OneToMany(mappedBy = "banque")
    private List<Agence> agences;
    
    @OneToMany(mappedBy = "banque")
    private List<Employe> employes;


}
