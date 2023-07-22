/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Combos {

   static  ResultSet rs = null;
          public String mx,sql;

       static PreparedStatement pst = null;

    public static JComboBox locs(JComboBox nn) throws SQLException  {
        nn.removeAll();
        nn.addItem("");
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "SELECT * from locations ";
        String fld="";
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {

         fld= rs.getString("loc");
          nn.addItem(fld);
        }

        return nn;
    }
     public static JComboBox cats(JComboBox nn) throws SQLException  {
        nn.removeAll();
        nn.addItem("");
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "SELECT * from tariff ";
        String fld="";
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {

         fld= rs.getString("cat");
          nn.addItem(fld);
        }

        return nn;
    }
     
     public static JComboBox typs(JComboBox nn) throws SQLException  {
        nn.removeAll();
        nn.addItem("");
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "SELECT * from loantypes order by nam ";
        String fld="";
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {

         fld= rs.getString("nam");
          nn.addItem(fld);
        }

        return nn;
    }
       public static JComboBox loans(JComboBox nn) throws SQLException  {
        nn.removeAll();
        nn.addItem("");
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "SELECT * from loantypes ";
        String fld="";
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {

         fld= rs.getString("nam");
          nn.addItem(fld);
        }

        return nn;
    }
    public static JComboBox bnchs(JComboBox nn) throws SQLException  {
        nn.removeAll();
        nn.addItem("");
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "SELECT * from bnchs ";
        String fld="";
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();
        String bcode="";
         String bank="";
          String bnch="";
           String bnk="";
        while (rs.next()) {

         bcode= rs.getString("bcode");
          bank= rs.getString("bank");
           bnch= rs.getString("bnch");
            bnk= rs.getString("bnk");
         fld= Tcase.toTitleCase(rs.getString("bnch"));
         System.out.print("'"+bcode +"',"+"'"+fld+"','"+bnch+"','"+bank+"','"+bnk+"'\n");
          nn.addItem(fld);
        }

        return nn;
    }
    
     public static JComboBox accgrps(JComboBox nn) throws SQLException  {
        nn.removeAll();
        nn.addItem("");
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "SELECT * from accountsgrp order by nam";
        String fld="";
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {

         fld= rs.getString("nam");
          nn.addItem(fld);
        }

        return nn;
    }
    
   
     
     
       public static JComboBox nkins(JComboBox nn) throws SQLException  {
        nn.removeAll();
        nn.addItem("");
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "SELECT * from relships order by relship";
        String fld="";
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {

         fld= rs.getString("relship");
          nn.addItem(fld);
        }

        return nn;
    }
     
     
     public static JComboBox mons(JComboBox nn)   {
         nn.removeAll();
         nn.addItem("");
        nn.addItem("January");
        nn.addItem("February");
        nn.addItem("March");
        nn.addItem("April");
        nn.addItem("May");
        nn.addItem("June");
        nn.addItem("July");
        nn.addItem("August");
        nn.addItem("September");
        nn.addItem("October");
        nn.addItem("November");
        nn.addItem("December");
        
        
        return nn;
    }
      public static JComboBox yrs(JComboBox nn)   {
          nn.removeAll();
          nn.addItem("");
          nn.addItem("2018");
          nn.addItem("2019");
          nn.addItem("2020");
          nn.addItem("2021");
          nn.addItem("2022");
          nn.addItem("2023");
          nn.addItem("2024");
          nn.addItem("2025");
          nn.addItem("2026");
          nn.addItem("2027");
          nn.addItem("2028");
          nn.addItem("2029");
          nn.addItem("2030");

        
        return nn;
    }
public static int validate_comboboxes(JComboBox nn[])  {
        int x = 0;

        int jj = nn.length;
        String sjj = Integer.toString(jj);
       // msbbox.show(Alert.AlertType.ERROR, sjj, "Can't Save Record", "Error");
        for (int i = 0; i < jj; i++) {
            if (nn[i].getSelectedItem() == null) {
                x = 1;
            }
        }
       if (x==1)
       {
            MessageBox.infoBox("Empty Fields Not Allowed", "Can't Save Record");
       }
        return x;

    }
}
