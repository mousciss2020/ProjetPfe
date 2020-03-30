package com.projetPfe.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projetPfe.models.entity.Employe;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

/**
 * ExcelView
 */
@Component(value = "employes.xlsx")
public class ExcelView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

         
        @SuppressWarnings("unchecked")
        List<Employe> employes = (List<Employe>) model.get("employes");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("User Detail");

        sheet.setDefaultColumnWidth(30);
      

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.DARK_GREEN.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);


        // create header row
        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("MATRICULE");
        header.getCell(0).setCellStyle(style);
        
        header.createCell(1).setCellValue("NOM");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("PRENOM");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("SERVICE");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("BANQUE");
        header.getCell(4).setCellStyle(style);
 

        /**
        header.createCell(3).setCellValue("Job Title");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Company");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Address");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("City");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Country");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Phone Number");
        header.getCell(8).setCellStyle(style);
        */


        int rowCount = 1;

        for(Employe emp : employes){
            Row userRow =  sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(emp.getMat());
            userRow.createCell(1).setCellValue(emp.getNom());
            userRow.createCell(2).setCellValue(emp.getPrenom());
            userRow.createCell(3).setCellValue(emp.getService().getNomService());
            userRow.createCell(4).setCellValue(emp.getBanque().getNomBanque());
            /**
            userRow.createCell(3).setCellValue(user.getJobTitle());
            userRow.createCell(4).setCellValue(user.getCompany());
            userRow.createCell(5).setCellValue(user.getAddress());
            userRow.createCell(6).setCellValue(user.getCity());
            userRow.createCell(7).setCellValue(user.getCountry());
            userRow.createCell(8).setCellValue(user.getPhoneNumber());
             */
            }

	}
    
}