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
import javafx.scene.control.Alert;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Validate_Expenses_Totals {

    static ResultSet rs = null;
    static String mx, sql;

    static PreparedStatement pst = null;
    static ResultSet rs1 = null;
    // static String mx, sql;

    static PreparedStatement pst1 = null;

    public static int validate(String yr, String mon) throws SQLException {
        String sdr = "0";
        double dr = 0;
        double cr = 0;
        int x = 0;
        String sql = "SELECT sum(amt) as dr FROM expenses  where yr='" + yr + "' and mon='" + mon + "' and typ='Debit'";
        Connection connx = DBconnect.ConnecrDb();
        pst = connx.prepareStatement(sql);
        System.out.println(sql);

        rs = pst.executeQuery();
        while (rs.next()) {

            sdr = rs.getString("dr");
            if (sdr == null) {

                sdr = "0";
            }
            dr = Double.parseDouble(sdr);

            //Code
        }

        //  System.out.println("dr="+sdr);
        String scr = getcr(yr, mon);
       // 
        cr = Double.parseDouble(scr);
       
        double bal = dr - cr;
       
        if (bal > 0 || bal < 0) {
            x = 1;
        }
        
        return x;

    }
static String getcr(String yr, String mon) throws SQLException
{
    String   scr="0";
    String sql = "SELECT sum(amt) as cr FROM expenses  where yr='" + yr + "' and mon='" + mon + "' and typ='Credit'";
        Connection conn0 = DBconnect.ConnecrDb();
        pst1 = conn0.prepareStatement(sql);
         System.out.println(sql);
        rs1 = pst1.executeQuery();
         while(rs1.next()){
           // rs1.first();
            scr = rs1.getString("cr");
            if(scr==null)
            {
                
                scr="0";
            }
         //    String mbal=Double.toString(bal);
        
          
        }
    
    return scr;
}

static double cramt(String yr, String mon) throws SQLException
{
    String   scr="0";
    String sql = "SELECT sum(amt) as cr FROM expenses  where yr='" + yr + "' and mon='" + mon + "' and typ='Credit'";
        Connection conn2 = DBconnect.ConnecrDb();
        pst1 = conn2.prepareStatement(sql);
          System.out.println(sql);
        rs1 = pst1.executeQuery();
         while(rs1.next()){
            scr = rs1.getString("cr"); 
         //  rs1.first();
          if(scr==null)
            {
                scr="0";
            }
        
         }
       //   msbbox.show(Alert.AlertType.ERROR, scr, "Can't Save Record", "Error");
        
        double mcr=Double.parseDouble(scr);
    return mcr;
}
static double dramt(String yr, String mon) throws SQLException
{
    String   sdr="0";
    String sql = "SELECT sum(amt) as dr FROM expenses  where yr='" + yr + "' and mon='" + mon + "' and typ='Debit'";
        Connection conn3 = DBconnect.ConnecrDb();
        pst1 = conn3.prepareStatement(sql);
          System.out.println(sql);
        rs1 = pst1.executeQuery();
         while(rs1.next()){
             sdr = rs1.getString("dr"); 
             // rs1.first();
              if(sdr==null)
            {
                sdr="0";
            }
          
          }
      
          double mdr=Double.parseDouble(sdr);
       //    msbbox.show(Alert.AlertType.ERROR, sdr, "Can't Save Record", "Error");
    
    return mdr;
}
}
