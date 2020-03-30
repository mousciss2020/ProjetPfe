package com.projetPfe.models.dao.categorie;

import com.projetPfe.models.entity.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CategorieRepos
 */
@Repository
public interface CategorieRepos extends JpaRepository<Categorie, Long>{

    
}