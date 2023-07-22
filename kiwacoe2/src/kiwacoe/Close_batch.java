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
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Close_batch {
   static  ResultSet rs = null;
   static     PreparedStatement pst = null;
     static void close(String cyr,String cmon, String batchname)
    {
        
    Connection conn = DBconnect.ConnecrDb();
    String sql = "update  "+batchname+" set stat='Posted' where yr='" + cyr + "' and mon='" + cmon + "'";
    System.out.println(sql);
    try {
        pst = conn.prepareStatement(sql);
        pst.executeUpdate(sql);
        //    rs= pst.executeQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Close_batch.class.getName()).log(Level.SEVERE, null, ex);
        msbbox.show(Alert.AlertType.ERROR, ex.toString(), "SQL Error", "ffff");
        return;
    }
       
}
}
 