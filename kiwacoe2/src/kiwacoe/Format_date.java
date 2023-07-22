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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import static kiwacoe.Loan_Repay_Capture_old.rs3;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Format_date {

    static String pattern = "###,##0.00";
    static DecimalFormat decimalFormat = new DecimalFormat(pattern);

    static String pattern3 = "###,###";
    static DecimalFormat decimalFormat3 = new DecimalFormat(pattern3);

    static String pattern2 = "######.00";
    static DecimalFormat decimalFormat2 = new DecimalFormat(pattern2);

    
    
      static String dmy(String dat) {
         String mdate[] = dat.split("-");
            String yy = mdate[0];
            String mm = mdate[1];
            String dd = mdate[2];
            String mdat=dd + "/" + mm + "/" + yy;

          return mdat;
    }
    
     static String ydm(String dat) {
         String mdate[] = dat.split("-");
            String dd = mdate[0];
            String mm = mdate[1];
            String yy = mdate[2];
            String mdat=yy + "/" + mm + "/" + dd;


         return mdat;
    }
}
