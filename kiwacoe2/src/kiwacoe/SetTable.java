/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JTable;
//import static javafxapplication9.FXMLDocumentController.conn;
 
/**
 *
 * @author user
 */
public class SetTable {

 //static  String pattern = "###,###.00";
 // static DecimalFormat decimalFormat = new DecimalFormat(pattern);
    

    static JTable data(JTable tab1) {
       
       tab1.setShowGrid(true); 
       tab1.setGridColor(Color.decode("000153255"));
       //tab1.set;
       return tab1;
    }
}
