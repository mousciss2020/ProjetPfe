package com.projetPfe.models.dao.employe;

import com.projetPfe.models.entity.Employe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeRepos
 */
@Repository
public interface EmployeRepos extends JpaRepository<Employe, Integer>{

   //public Employe findByMat(Long mat);

    
}