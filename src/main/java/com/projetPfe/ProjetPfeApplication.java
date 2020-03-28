package com.projetPfe;

import java.util.Date;

import com.projetPfe.models.dao.agence.AgenceRepos;
import com.projetPfe.models.dao.banque.BanqueRepos;
import com.projetPfe.models.dao.employe.EmployeRepos;
import com.projetPfe.models.dao.service.ServiceRepos;
import com.projetPfe.models.entity.Agence;
import com.projetPfe.models.entity.Banque;
import com.projetPfe.models.entity.Employe;
import com.projetPfe.models.entity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetPfeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetPfeApplication.class, args);
	}

	@Autowired
	private ServiceRepos service;
	@Autowired
	private EmployeRepos employe;
	@Autowired
	BanqueRepos banque;
	@Autowired
	AgenceRepos agence;

	@Override
	public void run(String... args) throws Exception {

		/*
		Services services = new Services();
		services.setNomService("Logistique");
		Services services1 = new Services();
		services1.setNomService("Matenance");

		Banque b1 = new Banque();
		b1.setNomBanque("Societe General");

		Agence a = new Agence();
		a.setNomAgence("Rabat agdal");
		a.setBanque(b1);
		
		
		Employe em = new Employe();
		em.setMat(642135L);em.setNom("Keita");em.setPrenom("Soleymane");
		em.setAdresse("Tabrequet Sale"); em.setCin("3452G");
		em.setCnss("230986NST");em.setDatEntre(new Date());em.setDateNaiss("01/01/1992");
		em.setLieuNaiss("Yomou");em.setNationalite("Guineenne");em.setGsm("0691023903");
		em.setStionFamiliale("Marié");

		em.setService(services1);
		em.setBanque(b1);
		em.setAgence(a);
		banque.save(b1); agence.save(a);
		service.save(services1);employe.save(em);
		*/
		
	}

}
