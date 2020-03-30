package com.projetPfe.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Employe
 */
@Entity
@Data @NoArgsConstructor @ToString
public class Employe implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Matricule")
    private String mat;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "Date_Entree")
    private Date datEntre;
    @Column(name = "CIN")
    private String cin;
    @Column(name = "Date_Naissance")
    private String dateNaiss;
    @Column(name = "Lieu_Naissance")
    private String lieuNaiss;
    @Column(name = "Nationalite")
    private String nationalite;
    @Column(name = "CNSS")
    private String cnss;
    @Column(name = "Motif")
    private String motif;
    @Column(name = "Mutuelle")
    private String mutuelle;
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "GSM")
    private String gsm;
    @Column(name = "Fixe")
    private String fixe;
    @Column(name = "Societe")
    private String societe;
    @Column(name = "Situation_Familiale")
    private String stionFamiliale;
    @Transient
    private MultipartFile files;

    @ManyToOne 
    private Contrat contrat;
    @ManyToOne
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Services service;
    @ManyToOne
    private Banque banque;

    @ManyToOne
    private Agence agence;

    public void getDateEntre(){
        this.datEntre = new Date();
    }
    
}