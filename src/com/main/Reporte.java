/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;

import com.bean.Asistente;
import com.data.AsistenteDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Anton
 */
public class Reporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        InputStream inputStream = null;
//        JasperPrint jasperPrint= null;
        AsistenteDataSource datasource = new AsistenteDataSource();
        
        
        for(int i = 0; i<=5; i++){
            
            Asistente asist;
            asist = new Asistente(i, "AsistenteNombre de "+i,"AsistenteApellidos de "+i, "Asistente dni de "+i);
            datasource.addAsistente(asist);
            
        }
        
       try {            
            File reportFile = new File("src/reports/report2.jasper");
            byte[] bytes = null;  
            bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), null, datasource);
            if(bytes != null){
                try (OutputStream out = new FileOutputStream("src/reports/report2.pdf")) {
                    out.write(bytes);
                }
            }
            System.out.println("OK");
            
//            inputStream = new FileInputStream ("src/reports/report2.jasper");
//            jasperPrint = JasperFillManager.fillReport("src/reports/report2.jasper", null, datasource);
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "src/reports/report2.pdf");
//            System.out.println("OK2");
            
        } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage());
        } catch (JRException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
