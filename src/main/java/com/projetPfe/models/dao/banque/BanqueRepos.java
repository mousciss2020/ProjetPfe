package com.projetPfe.models.dao.banque;

import com.projetPfe.models.entity.Banque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BanqueRepos
 */
@Repository
public interface BanqueRepos extends JpaRepository<Banque, Long>{

    
}