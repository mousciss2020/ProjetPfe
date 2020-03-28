package com.projetPfe.controllers.employe;

import com.projetPfe.models.dao.employe.EmployeRepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


/**
 * employeController
 */
@Controller
public class employeController {

    @Autowired
    private EmployeRepos employeRepo;
    public String index(Model model){
        model.addAttribute("employes", employeRepo.findAll());
        return "_indexEmploye";
    }

    
}