package com.projetPfe.models.service;

import java.util.Iterator;
import java.util.List;

import com.projetPfe.models.dao.banque.BanqueRepos;
import com.projetPfe.models.dao.employe.EmployeRepos;
import com.projetPfe.models.dao.service.ServiceRepos;
import com.projetPfe.models.entity.Banque;
import com.projetPfe.models.entity.Employe;
import com.projetPfe.models.entity.Services;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * EmployeServiceImpl
 */
@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeRepos employeRepos;
    @Autowired
    private ServiceRepos serv;
    @Autowired
    private BanqueRepos banq;
    

    @Override
    public List<Employe> findAllEmploye() {
        
        return (List<Employe>)employeRepos.findAll();
    }

    @Override
    public boolean saveFileExcel(MultipartFile files) {
        boolean isFlag = false;
        String extension = FilenameUtils.getExtension(files.getOriginalFilename());
        if (extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx")) {
            isFlag = readDataExcel(files);
        }
        return isFlag;
    }
    private boolean readDataExcel(MultipartFile files) {

        Workbook workbook = getWorkBook(files);
        Sheet  sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()) {
            Row row = rows.next();
            Employe emp = new Employe();
            Services s = new Services();
            Banque b = new Banque();
            
            if (row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
                //String mat = NumberToTextConverter.toText(row.getCell(0).getNumericCellValue());
                emp.setMat(row.getCell(0).getStringCellValue());
            }

            if (row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
                emp.setNom(row.getCell(1).getStringCellValue());
            }
            if (row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
                emp.setPrenom(row.getCell(2).getStringCellValue());
            }
            
            if (row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING) {
                //emp.getService().setNomService(row.getCell(3).getStringCellValue());
                s.setNomService(row.getCell(3).getStringCellValue());
                emp.setService(s);
                serv.save(s);
            }
            
            if (row.getCell(4).getCellType() == Cell.CELL_TYPE_STRING) {
                //emp.getBanque().setNomBanque(row.getCell(4).getStringCellValue());
                b.setNomBanque(row.getCell(4).getStringCellValue());
                emp.setBanque(b);
                banq.save(b);
            }
            employeRepos.save(emp); 
        }
        return true;
    }

    private Workbook getWorkBook(MultipartFile files) {
        Workbook workbook = null;
        String extension = FilenameUtils.getExtension(files.getOriginalFilename());
        try {
            if (extension.equalsIgnoreCase("xlsx")) {

                workbook = new XSSFWorkbook(files.getInputStream());

            } else if (extension.equalsIgnoreCase("xls")) {
                workbook = new HSSFWorkbook(files.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

}

    