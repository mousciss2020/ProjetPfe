package com.projetPfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * folderController
 */
@Controller
public class folderController {

    @GetMapping(value = "/attestion-stage")
    public String attstage(Model model){
       
        return "attstage";
    }
    @GetMapping(value = "/attestion-travail")
    public String attravail(Model model){
       
        return "attravail";
    }
    @GetMapping(value = "/attestion-domic")
    public String domiciliation(Model model){
       
        return "domiciliation";
    }

    
}