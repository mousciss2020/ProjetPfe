package com.projetPfe.models.dao.contrat;

import com.projetPfe.models.entity.Contrat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ContratRepos
 */
@Repository
public interface ContratRepos extends JpaRepository<Contrat, Long>{

    
}