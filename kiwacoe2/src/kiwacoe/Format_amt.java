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
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Format_amt {

    static String pattern = "###,##0.00";
    static DecimalFormat decimalFormat = new DecimalFormat(pattern);

    static String pattern3 = "###,###";
    static DecimalFormat decimalFormat3 = new DecimalFormat(pattern3);

    static String pattern2 = "######.00";
    static DecimalFormat decimalFormat2 = new DecimalFormat(pattern2);

    static String format(String amt) {
        // tring amt = rs.getString("amt"); //+"\n";
        // Double.parseDouble(amt)
        double mamt = Double.parseDouble(amt);
        // nam = nam.replace(",", " ");
        amt = decimalFormat.format(mamt);

        return amt;
    }
    
    
      static String formatx(String amt) {
          // tring amt = rs.getString("amt"); //+"\n";
          // Double.parseDouble(amt)
          double mamt = Double.parseDouble(amt);
          // nam = nam.replace(",", " ");
          amt = decimalFormat3.format(mamt);

          return amt;
    }
    
     static String uformat(String amt) {
         // tring amt = rs.getString("amt"); //+"\n";
         // Double.parseDouble(amt)
         //  double mamt=Double.parseDouble(amt);
         // nam = nam.replace(",", " ");
         //  amt = decimalFormat2.format(mamt);
         amt = amt.replace(",", "");
         amt = amt.replace(" ", "");
          amt = amt.replace(".00", "");

         return amt;
    }
}
