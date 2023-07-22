/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
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
public class ExportExcel {
   static  InputStream st=null;
    static String filename="d:\\rahoso\\tabledata.xls"; 
    
     static void preview(JTable jTable1,int [] ss )
    {
      
     
        try {
               // TODO add your handling code here:
               exportTable(jTable1, new File(filename),ss);
           } catch (IOException ex) {
               Logger.getLogger(Query_expenses.class.getName()).log(Level.SEVERE, null, ex);
               MessageBox.infoBox(ex.toString(), filename);
           }
        openfile();
   }
  static void openfile() {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(filename);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }
    static void exportTable0(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        for (int i = 0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                try {

                    //   if model.getValueAt(i, j).t
                    out.write(model.getValueAt(i, j).toString() + " \t");
                } catch (IOException ex) {
                    // Logger.getLogger(testfrmae.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            out.write("\n");
        }

        out.close();
        System.out.println("write out to: " + file);
    }
    

    static void exportTable(JTable table, File file,int[] uu) throws IOException {
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        for (int i = 0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                try {                   
                      if(uu[j]==1)
                      {
                         out.write("`"+model.getValueAt(i, j).toString() + " \t");
                      }else
                      {
                         // int x=0;
                        //   MessageBox.infoBox(Integer.toString(len), filename);
                         out.write(model.getValueAt(i, j).toString() + " \t");
                      }
                } catch (IOException ex) {
                    // Logger.getLogger(testfrmae.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            out.write("\n");
        }
        out.close();
        System.out.println("write out to: " + file);
    }
}
