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
import javafx.event.Event;
import javafx.scene.control.Alert;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Period_close {
     
    public static String mx, sql, xaccno, xtyp, xyr, xmon, xbf, xintr, xcf, xnam, xrate, xamt, xmembid, xloanid;
    static ResultSet rs = null;
    static PreparedStatement pst = null;
    static ResultSet rs2 = null;
    static PreparedStatement pst2 = null;
    static ResultSet rs3 = null;
    static PreparedStatement pst3 = null;
  static   Connection  connx = DBconnect.ConnecrDb();;
     static Connection conn = null;
    public static void close(String yr, String mon) {
        xyr = yr;
        xmon = mon;
        try {
            calculate_interest();
        } catch (SQLException ex) {
            Logger.getLogger(Period_close.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    
      static void calculate_interest() throws SQLException
    {
        
        //String sx = membid.getText().toString();
        sql = "SELECT * from balx where amt>0 order by accno ";

        

        pst = connx.prepareStatement(sql);
        System.out.println(sql);

        rs = pst.executeQuery();
        rs.first();
        readdata();
        // double cnt=0;
        while (rs.next()) {
           
             readdata();

        }
    }

    

    static void readdata() throws SQLException {
        //accno 	loanid 	typ 	yr 	mon 	bf 	intr 	cf 	nam 
      xaccno  = rs.getString("accno");
       xamt  = rs.getString("amt");
        xtyp  = rs.getString("typ");
      //   xmembid  = rs.getString("membid");
          xnam  = rs.getString("nam");
          xbf=xamt;
         Double bf= Double.parseDouble(xbf);
         double intr=0;
         double cf=0;
         intr=bf*get_interest_rate(xtyp)/100;
         cf=bf+intr;
         xcf=Double.toString(cf);
          xintr=Double.toString(intr);
    
            double pamt= get_principal_amt(xaccno) ;
                
                double zamt=Double.parseDouble(xamt);
               String camt=Double.toHexString(pamt);
                String zzamt=Double.toHexString(zamt);
               
          String ztyp =get_interesttype(xtyp);
         //  insert_rec();
        //   msbbox.show(Alert.AlertType.ERROR, ztyp, "Save Method", "Database Error");
        
           
         if (ztyp.equals("R"))
         {
             insert_rec();
         }
          if (ztyp.equals("F")  && pamt==zamt)
         {
             insert_rec();
         }

    }
    
    static void insert_rec()
    {
       
        sql = "insert into mbals (accno,typ,yr,mon,bf,intr,cf,nam,rate,pdate,ptime) values("  
                + xaccno+
                 ",'"+xtyp+"'"
                + ",'"+xyr+"'"
                + ",'"+xmon+"'"
                + ","+xbf+""
                + ","+xintr+""
                 + ","+xcf+""
                 + ",'"+xnam+"'"
                 + ","+xrate+",CURDATE(),CURTIME())";
   //     msbbox.show(Alert.AlertType.ERROR, sql, "Save Method", "Database Error");
       
        System.out.println(sql);
        try {

            pst2 = conn.prepareStatement(sql);
            pst2.executeUpdate(sql);
            //    rs= pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Period_close.class.getName()).log(Level.SEVERE, null, ex);
          msbbox.show(Alert.AlertType.ERROR, ex.toString(), "Save Method", "Database Error");
          //  return;
        }

       // msbbox.show(Alert.AlertType.ERROR, "New record saved successfully", "New Record", "ffff");
      
    }
 
    static double get_interest_rate(String typ) throws SQLException
    {
       double  intr=0;
        
         sql = "SELECT * from loantypes where nam='"+typ +"'";

     //   Connection connx = DBconnect.ConnecrDb();

        pst3 = connx.prepareStatement(sql);
        System.out.println(sql);

        rs3 = pst3.executeQuery();
        rs3.first();
      String xint_rate=  rs3.getString("intr");
     // xmembid=  rs.getString("membid");
      xloanid=  rs3.getString("loanid");
      xrate=xint_rate;
      intr=  Double.parseDouble(xint_rate);
      
        return intr;
    }
            
 static double get_principal_amt(String xaccno) throws SQLException
 {
     double amt=0;
     
      ResultSet rs333= null;
    PreparedStatement pst333 = null;
     
       sql = "SELECT * from loans where accno="+xaccno +"";

      //  Connection connx = DBconnect.ConnecrDb();

        pst333 = connx.prepareStatement(sql);
        
        System.out.println(sql);
      
        rs333 = pst333.executeQuery();
        rs333.first();
      String mamt=  rs333.getString("amt");
      String mfee=  rs333.getString("fee");
      double zamt= Double.parseDouble(mamt);
       double zfee= Double.parseDouble(mfee);
      amt=zamt+zfee;
      
     // msbbox.show(Alert.AlertType.ERROR, mamt, "Save Method", "Database Error");
     return amt;
     
     
 }
 static String get_interesttype(String xtyp) throws SQLException
 {
     double amt=0;
     
      ResultSet rs33= null;
    PreparedStatement pst33 = null;
     
       sql = "SELECT * from loantypes where nam='"+xtyp +"'";
       // msbbox.show(Alert.AlertType.ERROR, sql, "Save Method", "Database Error");

      //  Connection connx = DBconnect.ConnecrDb();

        pst33 = connx.prepareStatement(sql);
        System.out.println(sql);

        rs33 = pst33.executeQuery();
        rs33.first();
      String intrtyp=  rs33.getString("intrtyp");
     
     return intrtyp;
     
     
 }
}
