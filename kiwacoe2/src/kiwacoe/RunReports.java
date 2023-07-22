/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class RunReports {
    
     static void preview(String filename,HashMap hm, String title)
    {
      
        Connection jdbcConnection = DBconnect.ConnecrDb();  
        //--------------------------------------------------------------------------------------------------------
        String reportFile =  "d:\\kiwacoe\\kiwacoe2\\build\\classes\\kiwacoe\\" + filename;
        File f = new File(reportFile); //String reportFile="C:/Users/user/Documents/NetBeansProjects/JavaFXApplication9/src/javafxapplication9/report2.jrxml";
      //   File f = new File(reportFile); //String reportFile="C:/Users/user/Documents/NetBeansProjects/JavaFXApplication9/src/javafxapplication9/report2.jrxml";
        try {
         //   MessageBox.infoBox(reportFile, "Report Preview");
            JasperDesign jasperDesign = JRXmlLoader.load(f);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            System.out.println(title);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, jdbcConnection);
            if (jasperPrint.getPages().isEmpty()) {
                MessageBox.infoBox("No data to display!!", "Report Preview");
                return;
            } else {
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle(title);
               
          //  JasperExportManager.exportReportToPdfFile(jasperPrint, "d:\\zzz.pdf");
                java.awt.Image im = Toolkit.getDefaultToolkit().getImage("logo22.jpg");
                jv.setIconImage(im);
                jv.setExtendedState(jv.MAXIMIZED_BOTH);
                jv.setVisible(true);
            }
            // System.out.println("Run Report file exists : " + hm.toString());
        } catch (Exception ex) {
            String connectMsg = "Could not create the report " + ex.getMessage() + " " + ex.getLocalizedMessage();
            MessageBox.infoBox(connectMsg, "Report Error");
            System.out.println(connectMsg);
        }
         

   }
         

   
      static void preview2(String filename,HashMap hm, String title,String outfile)
    {
      
       MessageBox.infoBox(outfile, "Report Preview");
        Connection jdbcConnection = DBconnect.ConnecrDb();  
        //--------------------------------------------------------------------------------------------------------
        String reportFile =  "d:\\kiwacoe\\kiwacoe2\\build\\classes\\kiwacoe\\" + filename;
        File f = new File(reportFile); //String reportFile="C:/Users/user/Documents/NetBeansProjects/JavaFXApplication9/src/javafxapplication9/report2.jrxml";
      //   File f = new File(reportFile); //String reportFile="C:/Users/user/Documents/NetBeansProjects/JavaFXApplication9/src/javafxapplication9/report2.jrxml";
        try {
         //   MessageBox.infoBox(reportFile, "Report Preview");
            JasperDesign jasperDesign = JRXmlLoader.load(f);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            System.out.println(title);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, jdbcConnection);
            if (jasperPrint.getPages().isEmpty()) {
              //  MessageBox.infoBox("No data to display!!", "Report Preview");
                return;
            } else {
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle(title);
               
            JasperExportManager.exportReportToPdfFile(jasperPrint, outfile);
             //   java.awt.Image im = Toolkit.getDefaultToolkit().getImage("logo22.jpg");
             //   jv.setIconImage(im);
             //   jv.setExtendedState(jv.MAXIMIZED_BOTH);
             //   jv.setVisible(true);
            }
            // System.out.println("Run Report file exists : " + hm.toString());
        } catch (Exception ex) {
            String connectMsg = "Could not create the report " + ex.getMessage() + " " + ex.getLocalizedMessage();
            MessageBox.infoBox(connectMsg, "Report Error "+filename);
            System.out.println(connectMsg);
        }
         

   }
        
}
