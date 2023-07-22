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
import javax.swing.JOptionPane;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Confirm {
 static int dialogResult ;
 static int dialogButton;
 static String ans;
 
    

    static String YesNo(String msg,String title) {
        int dialogResult = JOptionPane.showConfirmDialog(null, msg, title, dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            ans="Y";
        }else
        {
            ans="N";
        }
        return ans;
    }
}
