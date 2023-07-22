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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JComboBox;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class GetMonth {

 static  String pattern = "###,###.00";
    static DecimalFormat decimalFormat = new DecimalFormat(pattern);

    static String format(String mon) {
        // tring amt = rs.getString("amt"); //+"\n";
        String xx[] = {" ", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int mn = Integer.parseInt(mon);
        mon = xx[mn];
        return mon;
       // GetMonth.
        //
    }
     static String Month_From_Combo(JComboBox hmon) {
        String mon= String.format("%02d", hmon.getSelectedIndex());
        return mon;
        //
    }
    
    static String[] set_yr_mon() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String mdat = dtf.format(now);
        //  System.out.println("aaa");
         String xx[]={" ","January","February","March","April","May","June","July","August","September","October","November","December"};
        String mdate[] = mdat.split("/");
        String y = mdate[0];
        String m = mdate[1];
        String d = mdate[2];
        int imon = Integer.parseInt(m);
        // System.out.println( y);
        int zmon = Integer.parseInt(m);
        String yrmon[]={xx[zmon],y};
       // MessageBox.infoBox(y, pattern);
       // mon.setSelectedIndex(zmon - 1);
       // yr.setSelectedItem(y);
       return yrmon;
    }
}
