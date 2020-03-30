package com.projetPfe.models.service;

import java.util.List;

import com.projetPfe.models.entity.Employe;

import org.springframework.web.multipart.MultipartFile;

/**
 * EmployeService
 */
public interface EmployeService {

    public List<Employe> findAllEmploye();
    public boolean saveFileExcel(MultipartFile files);
}