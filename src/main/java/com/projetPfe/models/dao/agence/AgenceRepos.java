package com.projetPfe.models.dao.agence;

import com.projetPfe.models.entity.Agence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AgenceRepos
 */
@Repository
public interface AgenceRepos extends JpaRepository<Agence, Long>{

    
}