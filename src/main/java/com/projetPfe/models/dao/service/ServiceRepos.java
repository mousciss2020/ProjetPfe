package com.projetPfe.models.dao.service;

import com.projetPfe.models.entity.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ServiceRepos
 */
@Repository
public interface ServiceRepos extends JpaRepository<Services, Integer>{

    
}