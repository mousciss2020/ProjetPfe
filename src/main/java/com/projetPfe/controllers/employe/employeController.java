package com.projetPfe.controllers.employe;

import com.projetPfe.models.entity.Employe;
import com.projetPfe.models.service.EmployeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * employeController
 */
@Controller
public class EmployeController {

    
    @Autowired
    EmployeService employeService;

    @GetMapping(value = { "/", "/employes" })
    public String index(Model model){
        model.addAttribute("titre", "Import Export du fichier Excel");
        model.addAttribute("employe", new Employe());
        model.addAttribute("employes", employeService.findAllEmploye());
        return "employes";
    }
    @PostMapping(value = "/uploadfile")
    public String uplodFile(@ModelAttribute Employe employe, RedirectAttributes redirectAttributes) {

        boolean isFlag = employeService.saveFileExcel(employe.getFiles());
        if (isFlag) {
            redirectAttributes.addFlashAttribute("msgsuccess", "Bien enregistrer");
        } else {
            redirectAttributes.addFlashAttribute("msgerreur", "Erreur");
        }

        return "redirect:/";
    }

    
}