package com.projetPfe.controllers;

import com.projetPfe.models.dao.employe.EmployeRepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * indexController
 */
@Controller
public class indexController {

    @Autowired
    EmployeRepos employeRepo;

    
    @GetMapping(value = "/add-personnel")
    public String add(Model model){ 
        String titre = "add";
        model.addAttribute("titre", titre);
        return "_addPersonnel";
    } 
    
}

